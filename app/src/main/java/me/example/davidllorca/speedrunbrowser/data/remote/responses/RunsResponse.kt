package me.example.davidllorca.speedrunbrowser.data.remote.responses

import com.google.gson.annotations.SerializedName
import me.example.davidllorca.speedrunbrowser.data.remote.RunItem

class RunsResponse {

    @SerializedName("data")
    var runItems: List<RunItem>? = null

}