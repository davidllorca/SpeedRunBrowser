package me.example.davidllorca.speedrunbrowser.di.application

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (NetworkModule::class), (SpeedRunApiModule::class)])
interface ApplicationComponent