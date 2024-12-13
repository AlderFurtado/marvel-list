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
    @State var offset = Int32(0)
    @State private var isLoadingMore = false
    
    let limit = Int32(100)
    
    func getCharacterList(offsetLocal: Int32) async {
        DispatchQueue.main.async {
            Task {
                do {
                    let data = try await Factories().getCharacterBasicInfoListUseCase().invoke(offset: offsetLocal, limit: limit)
                    let dataT = data.map{ character in
                        CharacterBasicInfo(name: character.name, imageUrl: replaceHttpToHttps(input: character.imageUrl), description: character.description_, lastModified: character.lastModified, numberOfEvents: character.numberOfEvents, numberOfComics: character.numberOfComics, numberOfSeries: character.numberOfSeries, numberOfStories: character.numberOfStories)
                    }
                    NSLog("offset = \(offset)")
                    self.characterBasicInfoList += dataT
                } catch {
                    print("Failed to fetch data: \(error.localizedDescription)")
                }
            }
        }
    }
    
    func replaceHttpToHttps(input: String) -> String{
        return input.replacingOccurrences(of: "http", with: "https")
    }
    
    func loadMoreCharacters() async {
        if(!isLoadingMore){
            self.offset += limit
            self.isLoadingMore = true
            await getCharacterList(offsetLocal: offset)
            self.isLoadingMore = false
        }
    }
    
    var body: some View {
        NavigationView{
            List(characterBasicInfoList, id: \.self) { item in
                let imageUrl = item.imageUrl+"/portrait_xlarge.jpg"
                HStack {
                    AsyncImage(url: URL(string: imageUrl)) { phase in
                                if let image = phase.image {
                                    image
                                        .resizable()
                                        .cornerRadius(4)
                                        .frame(width: 140, height: 140)
                                } else if phase.error != nil {
                                    Text("Failed to load image")
                                } else {
                                    ProgressView() // Placeholder while loading
                                }
                            }
                            .frame(width: 140, height: 140)
                 
                    VStack(alignment:.leading,spacing: 4, content: {
                        Text(item.lastModified)
                            .font(.footnote).foregroundStyle(.gray)
                        Text(item.name)
                            .font(.title3)
                            .bold()
                        Text(item.description_ ?? "N/A")
                            .font(.caption)
                            .lineLimit(2)
                        Spacer()
                        HStack{
                            Spacer()
                            Button(action: {
                                print("\(item) button clicked")
                            }){
                                Text("More")
                                    .font(.footnote)
                                    .padding(.horizontal,20)
                                    .padding(.vertical,8)
                                    .background(.red)
                                    .foregroundColor(.white)
                                    .cornerRadius(4)
                            }.buttonStyle(PlainButtonStyle())
                        }
                    })
                    .padding(4)
                }
                    .listRowInsets(EdgeInsets())
                    .frame(height:150)
                    .onAppear {
                        if item == characterBasicInfoList.last {
                            Task {
                                await loadMoreCharacters()
                            }
                        }
                    }
               
            }.task {
                await getCharacterList(offsetLocal: offset)
            }
            //TODO fix this
            if isLoadingMore {
                    ProgressView()
            }
          
        }
        .navigationTitle("Characters")
    }
}


#Preview {
    CharacterListView()
}
