package me.example.davidllorca.speedrunbrowser.data.remote

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Remote server Endpoints.
 */
interface SpeedRunApi {

    @GET("/api/v1/games")
    fun getGames(): Single<GamesResponse>

}