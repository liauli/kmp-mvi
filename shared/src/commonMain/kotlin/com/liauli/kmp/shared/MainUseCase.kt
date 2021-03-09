package com.liauli.kmp.shared

import com.liauli.kmp.shared.MainIntent.*
import com.liauli.kmp.shared.domain.FetchVideo
import com.liauli.kmp.shared.mvi.MviEvent
import com.liauli.kmp.shared.mvi.MviIntent
import com.liauli.kmp.shared.mvi.MviState
import com.liauli.kmp.shared.mvi.UseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


@FlowPreview
@ExperimentalCoroutinesApi
internal class MainUseCase(
    private val fetchVideo: FetchVideo,
    private val scope: CoroutineScope
) : UseCase<MainIntent, MainState, MainEvent> {

    private val intentFlow = MutableSharedFlow<MainIntent>()
    private val uiStates = MutableStateFlow(MainState())
    private val events = MutableSharedFlow<MainEvent>()

    private val intentToAction = { incomingFlow: Flow<MainIntent> ->
        incomingFlow.map { intent ->
            when (intent) {
                InitialLoadIntent -> MainAction.InitialLoadAction
            }
        }
    }

    private val intentFilter = { incomingFlow: Flow<MainIntent> ->
        val sharedFlow = incomingFlow.shareIn(scope, SharingStarted.Eagerly)
        merge(
            sharedFlow.filter { it == InitialLoadIntent }.take(1)
        )
    }

    private val actionProcessor = { incomingFlow: Flow<MainAction> ->
        val sharedFlow = incomingFlow.shareIn(scope, SharingStarted.Eagerly)
        val actionInitialLoad = { actionFlow: Flow<MainAction.InitialLoadAction> ->
            actionFlow.flatMapConcat {
                flow<MainResult> {
                    emitAll(
                        fetchVideo.execute()
                            .map { MainResult.LoadResult.Success(it?.play_list ?: emptyList()) })
                }.catch {
                    emit(MainResult.LoadResult.Failed)
                }
                    .onStart {
                        emit(MainResult.LoadResult.Loading)
                    }
                    .flowOn(Dispatchers.Default)
            }
        }

        merge(
            sharedFlow.filter { it is MainAction.InitialLoadAction }
                .map { it as MainAction.InitialLoadAction }
                .let(actionInitialLoad)
        )
    }

    private val reducer = { resultFlow: Flow<MainResult> ->
        resultFlow.scan(MainState()) { previousState, result ->
            when (result) {
                MainResult.LoadResult.Loading -> previousState.copy(isLoading = true)
                is MainResult.LoadResult.Success -> previousState.copy(
                    isLoading = false,
                    data = result.video
                )
                MainResult.LoadResult.Failed -> previousState.copy(
                    isLoading = false,
                    isError = true
                )
            }
        }
    }

    override fun emit(intent: MainIntent) {
        scope.launch {
            intentFlow.emit(intent)
        }
    }

    override fun getUiStates(): MutableStateFlow<MainState> {
        return uiStates
    }

    override fun getEvents(): MutableSharedFlow<MainEvent> {
        return events
    }

    init {
        intentFlow
            .let(intentFilter)
            .let(intentToAction)
            .let(actionProcessor)
            .let(reducer)
            .onEach { newState ->
                uiStates.emit(newState)
            }
            .launchIn(scope)

    }

    //for iOS
    fun stopObserving() {
        scope.cancel()
    }
}

sealed class MainAction {
    object InitialLoadAction : MainAction()
}

sealed class MainResult {
    sealed class LoadResult : MainResult() {

        object Loading : LoadResult()
        data class Success(
            val video: List<Video>
        ) : LoadResult()

        object Failed : LoadResult()
    }
}

data class MainState(
    val isLoading: Boolean = false,
    val data: List<Video>? = null,
    val isError: Boolean = false
) : MviState

enum class MainIntent : MviIntent {
    InitialLoadIntent
}

sealed class MainEvent : MviEvent