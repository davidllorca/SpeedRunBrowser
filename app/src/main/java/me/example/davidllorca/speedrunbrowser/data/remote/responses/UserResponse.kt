package me.example.davidllorca.speedrunbrowser.data.remote.responses

import com.google.gson.annotations.SerializedName
import me.example.davidllorca.speedrunbrowser.data.remote.model.UserItem

class UserResponse {

    @SerializedName("data")
    var userItem: UserItem? = null

}
