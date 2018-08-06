package me.example.davidllorca.speedrunbrowser.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.data.remote.responses.RunsResponse
import me.example.davidllorca.speedrunbrowser.domain.common.BaseUseCase
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.toRun

class RunsUseCase(private val api: SpeedRunApi,
                  private val workScheduler: Scheduler,
                  private val deliveryScheduler: Scheduler)
    : BaseUseCase<RunsUseCase.Params, List<Run>> {

    override fun execute(params: Params): Single<List<Run>> {
        return api.getRuns(params.game.id)
                .map { response: RunsResponse -> response.runItems?.toRun() ?: emptyList() }
                .subscribeOn(workScheduler)
                .observeOn(deliveryScheduler)
    }

    class Params(val game: Game)
}

