package cal

import android.app.Application
import cal.di.dataModule
import cal.di.databaseModule
import cal.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf( viewModelModule, databaseModule,dataModule))
        }
    }
}