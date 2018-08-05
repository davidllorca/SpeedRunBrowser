package me.example.davidllorca.speedrunbrowser.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Objects to handle [SpeedRunApi] responses.
 */
class GameItem {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("names")
    @Expose
    var names: Names? = null
    @SerializedName("assets")
    @Expose
    var assets: Assets? = null
    @SerializedName("links")
    @Expose
    var links: List<Link>? = null

}

class Assets {

    @SerializedName("logo")
    @Expose
    var logo: Logo? = null

}

class Link {

    @SerializedName("rel")
    @Expose
    var rel: String? = null
    @SerializedName("uri")
    @Expose
    var uri: String? = null

}

class Logo {

    @SerializedName("uri")
    @Expose
    var uri: String? = null
    @SerializedName("width")
    @Expose
    var width: Int? = null
    @SerializedName("height")
    @Expose
    var height: Int? = null

}

class Names {

    @SerializedName("international")
    @Expose
    var international: String? = null

}

class RunItem {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("game")
    @Expose
    var game: String? = null
    @SerializedName("videos")
    @Expose
    var videos: Videos? = null
    @SerializedName("players")
    @Expose
    var players: List<Player>? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("submitted")
    @Expose
    var submitted: String? = null
    @SerializedName("times")
    @Expose
    var times: Times? = null

}

class Player {

    @SerializedName("rel")
    @Expose
    var rel: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("uri")
    @Expose
    var uri: String? = null

}

class Times {

    @SerializedName("realtime_t")
    @Expose
    var realtimeT: Int? = null

}

class Videos {

    @SerializedName("links")
    @Expose
    var links: List<Link>? = null

}