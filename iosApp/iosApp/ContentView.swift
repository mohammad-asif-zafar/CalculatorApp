import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        Button("Click Me") {
            SharedModuleKt.showToast(message: "Hello from iOS!")
        }
    }
}
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
