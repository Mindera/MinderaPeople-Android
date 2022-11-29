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
        MinderaPeopleAppKt.shared.start()
        let appVersion = Bundle.main.infoDictionary?["CFBundleShortVersionString"] as? String
        print(appVersion)
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
