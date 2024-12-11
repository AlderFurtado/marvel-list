//
//  SwiftUIView.swift
//  iosApp
//
//  Created by Alder Furtado on 04/12/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharacterListView: View {
    
    @State private var characterBasicInfoList: [CharacterBasicInfo] = []
    
    func getCharacterList(){
        DispatchQueue.main.async {
            Task {
                do {
                    let data = try await Factories().getCharacterBasicInfoListUseCase().invoke(offset: 0, limit: 100)
                        NSLog("App started with state: %@", "\(data)")
                        self.characterBasicInfoList = data
                } catch {
                    print("Failed to fetch data: \(error.localizedDescription)")
                }
            }
        }

    }
    
    var body: some View {
        List(characterBasicInfoList, id: \.self) { item in
            Text(item.name)
        }.task {
            getCharacterList()
        }
    }
}
//
//#Preview {
//    SwiftUIView()
//}
