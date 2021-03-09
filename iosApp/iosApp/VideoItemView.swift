//
//  VideoItemView.swift
//  iosApp
//
//  Created by Quipper Indonesia on 01/03/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared


struct VideoItemView: View {
    var video: Video
    
    var body: some View {
        HStack{
            RemoteImage(url:video.thumbnail_url)
                .aspectRatio(contentMode: .fit)
                .frame(height: 70)
            VStack(alignment: .leading){
                Text(video.title)
//                Text(video.presenter_name)
            }.padding()
        }
    }
}


