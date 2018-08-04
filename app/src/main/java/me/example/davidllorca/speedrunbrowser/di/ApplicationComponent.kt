package me.example.davidllorca.speedrunbrowser.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

import me.example.davidllorca.speedrunbrowser.ui.MyApplication
import me.example.davidllorca.speedrunbrowser.ui.games.GamesModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (GamesModule::class),
    (NetworkModule::class),
    (SpeedRunApiModule::class)
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(myApplication: MyApplication)
}