package me.example.davidllorca.speedrunbrowser.domain.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.example.davidllorca.speedrunbrowser.data.remote.RemoteRequester
import me.example.davidllorca.speedrunbrowser.domain.usecase.GamesUseCase
import me.example.davidllorca.speedrunbrowser.domain.usecase.RunsUseCase
import me.example.davidllorca.speedrunbrowser.domain.usecase.UserUseCase
import javax.inject.Named
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun getGamesUseCase(requester: RemoteRequester): GamesUseCase {
        return GamesUseCase(requester, workerScheduler(), deliveryScheduler())
    }

    @Singleton
    @Provides
    fun getRunsUseCase(requester: RemoteRequester): RunsUseCase {
        return RunsUseCase(requester, workerScheduler(), deliveryScheduler())
    }

    @Singleton
    @Provides
    fun getUserUseCase(requester: RemoteRequester): UserUseCase {
        return UserUseCase(requester, workerScheduler(), deliveryScheduler())
    }

    @Provides
    @Named("worker_scheduler")
    fun workerScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Named("delivery_scheduler")
    fun deliveryScheduler(): Scheduler = AndroidSchedulers.mainThread()

}