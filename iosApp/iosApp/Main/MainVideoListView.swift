//
//  MainVideoListView.swift
//  iosApp
//
//  Created by Quipper Indonesia on 09/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import AVKit

struct MainVideoListView: View {
    var videos: [Video]
    
    var body: some View {
        List(videos){video in
            NavigationLink(destination:
                VideoDetails(video: video, player: AVPlayer(url: URL(string: video.video_url)!))){
                VideoItemView(video: video)
            }
        }.navigationTitle("Video List")
    }
}
