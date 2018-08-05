package me.example.davidllorca.speedrunbrowser.data.remote

import io.reactivex.Single
import me.example.davidllorca.speedrunbrowser.data.remote.responses.GamesResponse
import me.example.davidllorca.speedrunbrowser.data.remote.responses.RunsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Remote server Endpoints.
 */
interface SpeedRunApi {

    @GET("/api/v1/games")
    fun getGames(): Single<GamesResponse>

    @GET("/api/v1/runs")
    fun getRuns(@Query("game") gameId: String): Single<RunsResponse>

}