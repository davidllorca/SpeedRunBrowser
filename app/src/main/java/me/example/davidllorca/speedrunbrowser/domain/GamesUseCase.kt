package me.example.davidllorca.speedrunbrowser.domain

import io.reactivex.Scheduler
import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.domain.common.BaseUseCase
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.toGame

class GamesUseCase(
        private val api: SpeedRunApi,
        private val workScheduler: Scheduler,
        private val deliveryScheduler: Scheduler)
    : BaseUseCase<NoParams, List<Game>> {

    override fun execute(params: NoParams): Single<List<Game>> {
        return api.getGames()
                .map { response -> response.gameItems?.toGame() ?: emptyList() }
                .subscribeOn(workScheduler)
                .observeOn(deliveryScheduler)
    }

}

