package com.liauli.kmp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.liauli.kmp.shared.Greeting
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.liauli.kmp.shared.MainIntent
import com.liauli.kmp.shared.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

fun greet(): String {
    return Greeting().greeting()
}

@FlowPreview
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)


        viewModel.getUiStates().asLiveData().observe(this, {state ->
            if(state.isLoading){
                Toast.makeText(this, "loading..", Toast.LENGTH_SHORT).show()
            }
            findViewById<TextView>(R.id.text_view).text = (state.data?.size?:0).toString()
        })

        viewModel.emit(MainIntent.InitialLoadIntent)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("state", "onDestory")
    }
}
