package me.example.davidllorca.speedrunbrowser.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import me.example.davidllorca.speedrunbrowser.data.di.NetworkModule
import me.example.davidllorca.speedrunbrowser.data.di.SpeedRunApiModule
import me.example.davidllorca.speedrunbrowser.domain.di.DomainModule

import me.example.davidllorca.speedrunbrowser.ui.MyApplication
import me.example.davidllorca.speedrunbrowser.ui.games.GamesModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (GamesModule::class),
    (DomainModule::class),
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