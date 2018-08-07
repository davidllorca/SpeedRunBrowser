package me.example.davidllorca.speedrunbrowser.data.remote

import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.data.remote.responses.GamesResponse
import me.example.davidllorca.speedrunbrowser.data.remote.responses.RunsResponse
import me.example.davidllorca.speedrunbrowser.data.remote.responses.UserResponse
import javax.inject.Inject

class RemoteRequester @Inject constructor(private val api: SpeedRunApi) {

    fun getGames(): Single<GamesResponse> = api.getGames()

    fun getRuns(gameId: String): Single<RunsResponse> = api.getRuns(gameId)

    fun getPlayer(userId: String): Single<UserResponse> = api.getPlayer(userId)

}