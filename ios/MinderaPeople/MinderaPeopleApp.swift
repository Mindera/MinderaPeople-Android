//
//  MinderaPeopleApp.swift
//  MinderaPeople
//
//  Created by TMApps on 04/10/2022.
//

import SwiftUI
import MinderaPeopleKt

@main
struct MinderaPeopleApp: App {

    init() {
        MinderaPeopleWrapper.shared.start()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
