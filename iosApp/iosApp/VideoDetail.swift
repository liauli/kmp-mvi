//
//  VideoDetail.swift
//  iosApp
//
//  Created by Quipper Indonesia on 02/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//
import SwiftUI
import AVKit
import shared

struct VideoDetails: View {
    
    var video: Video
    var player: AVPlayer

    var body: some View {
        VStack(alignment: .leading){
            VideoPlayer(player: player)
            Text(video.title).font(.title)
            Text(video.author).font(.subheadline)
            Text(video.description_).font(.body)
        }.padding()
        .onDisappear(){
            player.pause()
        }
        Spacer()
    }
    
}

