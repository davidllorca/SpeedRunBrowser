package me.example.davidllorca.speedrunbrowser.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import me.example.davidllorca.speedrunbrowser.data.remote.responses.UserResponse
import me.example.davidllorca.speedrunbrowser.domain.common.BaseUseCase
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.domain.model.toUser

class UserUseCase(
        private val api: SpeedRunApi,
        private val workScheduler: Scheduler,
        private val deliveryScheduler: Scheduler)
    : BaseUseCase<UserUseCase.Params, User> {

    override fun execute(params: Params): Single<User> {
        return api.getPlayer(params.userId)
                .map { response: UserResponse ->
                    response.userItem?.toUser() ?: User("", "")
                } // TODO SOLVE THIS SHIT
                .subscribeOn(workScheduler)
                .observeOn(deliveryScheduler)
    }

    class Params(val userId: String)
}


