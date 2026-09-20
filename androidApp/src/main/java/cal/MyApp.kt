package cal

import android.app.Application
import cal.di.platformModule
import cal.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(sharedModule, platformModule()))
        }
    }
}
