package me.example.davidllorca.speedrunbrowser.data.remote.responses

import com.google.gson.annotations.SerializedName
import me.example.davidllorca.speedrunbrowser.data.remote.model.RunItem

class RunsResponse {

    @SerializedName("data")
    var runItems: List<RunItem>? = null

}