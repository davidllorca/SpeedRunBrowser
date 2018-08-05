package me.example.davidllorca.speedrunbrowser.domain.di

import dagger.Module
import dagger.Provides
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.domain.GamesUseCase

@Module
class DomainModule {

    @Provides
    fun getGamesUseCase(api: SpeedRunApi): GamesUseCase {
        return GamesUseCase(api)
    }
}