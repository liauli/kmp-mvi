//
//  MainInitialView.swift
//  iosApp
//
//  Created by Quipper Indonesia on 09/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MainInitialView: View {
    var viewModel: ViewModel
    var body: some View {
        Button(action: {
            viewModel.emit(intent: MainIntent.initialloadintent)
        }, label: {
            Text("Load Video")
        })
    }
}

