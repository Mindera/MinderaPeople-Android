//
//  ContentView.swift
//  MinderaPeople
//
//  Created by Mindera on 04/10/2022.
//

import SwiftUI
import MinderaPeopleKt

struct ContentView: View {

    private let minderaPeople = MinderaPeopleWrapper.shared

    var body: some View {
        ZStack {
            Color(hex: 0x4f5b66)
        }
        .onAppear { onViewAppear() }
    }

    private func onViewAppear() {
//        minderaPeople.networkConnectionObservation() { [self] networkConnection in
//            self.connection = networkConnection
//
//            minderaPeople.getCurrentIpInfo() { [self] result, error in
//                self.ipInfo = result
//            }
//        }
    }
}

extension Color {
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
