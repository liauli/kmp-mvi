//
//  ViewModel.swift
//  iosApp
//
//  Created by Quipper Indonesia on 02/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class ViewModel: ObservableObject {
    @Published var state : MainState = MainState(isLoading: false, data: nil, isError: false)
    
    var viewModel : MainViewModel
    
    init(fetchVideo: FetchVideo) {
       viewModel = MainViewModel(fetchVideo: fetchVideo)
    }
    
    func stopObserving(){
        viewModel.stopObserving()
    }
    
    func emit(intent: MainIntent){
        viewModel.emit(intent: intent)
    }
    
    func startObserving(){
        viewModel.getStates().collect(
                   collector: Collector<MainState>{res in
                       self.state = res
                   },
            completionHandler: {(unit, err) in})
    }
}
