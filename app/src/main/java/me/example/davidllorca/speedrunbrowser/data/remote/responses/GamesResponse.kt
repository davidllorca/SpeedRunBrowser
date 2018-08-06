package me.example.davidllorca.speedrunbrowser.data.remote.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import me.example.davidllorca.speedrunbrowser.data.remote.model.GameItem


class GamesResponse {

    @SerializedName("data")
    @Expose
    var gameItems: List<GameItem>? = null

}