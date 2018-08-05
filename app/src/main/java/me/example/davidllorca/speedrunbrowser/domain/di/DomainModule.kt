package me.example.davidllorca.speedrunbrowser.domain.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.domain.GamesUseCase
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun getGamesUseCase(api: SpeedRunApi): GamesUseCase {
        return GamesUseCase(api, workerScheduler(), deliveryScheduler())
    }

    @Provides
    @Named("worker_scheduler")
    fun workerScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Named("delivery_scheduler")
    fun deliveryScheduler(): Scheduler = AndroidSchedulers.mainThread()

}