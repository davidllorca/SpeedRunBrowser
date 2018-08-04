import android.app.Application
import me.example.davidllorca.speedrunbrowser.di.application.ApplicationComponent
import me.example.davidllorca.speedrunbrowser.di.application.ApplicationModule
import me.example.davidllorca.speedrunbrowser.di.application.DaggerApplicationComponent

class MyApplication : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }


    fun getApplicationComponent(): ApplicationComponent? {
        return mApplicationComponent
    }

}
