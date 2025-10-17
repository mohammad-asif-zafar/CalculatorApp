import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greet()
    
    var body: some View {
        VStack{
            
            Button(action:{
                // exection  later
            },
                   label:{
                Image("Donut")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(height: 40)
                        }
                   
                   
            )
            
            Button(action:{
                
            },
                   label: {
                
            }
            
            )
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
