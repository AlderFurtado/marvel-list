//
//  HomeView.swift
//  iosApp
//
//  Created by Alder Furtado on 12/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    let categories = ["Characters","Comics","Events","Stories","Creators","Series"]
    var body: some View {
        Text("Categories")
            .font(.largeTitle)
        .bold()
        List(categories, id: \.self){ category in
            Text(category)
                .padding(.vertical,8)
                .font(.title2)
               
        }
        .listStyle(PlainListStyle()) // Use a plain style to remove
             .padding(0)
             .padding(.leading,16)
    }
}

#Preview {
    HomeView()
}
