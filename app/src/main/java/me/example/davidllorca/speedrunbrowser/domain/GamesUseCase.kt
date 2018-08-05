package me.example.davidllorca.speedrunbrowser.domain

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.domain.common.BaseUseCase
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.toGame

class GamesUseCase(private val api: SpeedRunApi) : BaseUseCase<NoParams, List<Game>> {

    override fun execute(params: NoParams): Single<List<Game>> {
        return api.getGames()
                .map { response -> response.gameItems?.toGame() ?: emptyList() }
                .subscribeOn(Schedulers.io())
    }

}

