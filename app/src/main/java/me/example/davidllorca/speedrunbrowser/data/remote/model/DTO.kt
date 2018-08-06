package me.example.davidllorca.speedrunbrowser.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Objects to handle [SpeedRunApi] responses.
 */
class GameItem {

    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("names")
    @Expose
    lateinit var names: Names
    @SerializedName("assets")
    @Expose
    lateinit var assets: Assets

}

class Assets {

    @SerializedName("logo")
    @Expose
    lateinit var logo: Logo

}

class Link {

    @SerializedName("uri")
    @Expose
    lateinit var uri: String

}

class Logo {

    @SerializedName("uri")
    @Expose
    lateinit var uri: String
    @SerializedName("width")
    @Expose
    var width: Int = 0
    @SerializedName("height")
    @Expose
    var height: Int = 0

}

class Names {

    @SerializedName("international")
    @Expose
    var international: String? = null

}

class RunItem {

    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("game")
    @Expose
    lateinit var gameId: String
    @SerializedName("videos")
    @Expose
    lateinit var videos: Videos
    @SerializedName("players")
    @Expose
    lateinit var players: List<Player>
    @SerializedName("times")
    @Expose
    lateinit var times: Times

}

class Player {

    @SerializedName("id")
    @Expose
    var id: String? = null

}

class Times {

    @SerializedName("realtime_t")
    @Expose
    var realtimeT: Int = 0

}

class Videos {

    @SerializedName("links")
    @Expose
    lateinit var links: List<Link>

}

class UserItem {

    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("names")
    @Expose
    lateinit var names: Names

}