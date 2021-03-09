import SwiftUI
import shared
import AVKit

extension Video: Identifiable { }

struct ContentView: View {
    
    @ObservedObject var viewModel = ViewModel(fetchVideo: FetchVideoImpl(videoRepository: VideoRepositoryImpl(videoApi: VideoApiImpl())))
    
    var body: some View {
        NavigationView{
            if(viewModel.state.isLoading){
                MainLoadingView()
            }else if(viewModel.state.data != nil){
                MainVideoListView(videos: viewModel.state.data!)
            }else{
                Text("Idle")
            }
        }.onAppear(){
            viewModel.startObserving()
            viewModel.emit(intent: MainIntent.initialloadintent)
        }.onDisappear(){
            viewModel.stopObserving()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

