package me.example.davidllorca.speedrunbrowser.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Domain classes to represent data(Visual Objects).
 */

@Parcelize
data class Game(val id: String, val name: String? = "name", val logo: Logo? = null) : Parcelable

@Parcelize
data class Run(val id: String, val game: Game?, val player: User? = null, val time: Int, val videoUrl: String?) : Parcelable

@Parcelize
data class Logo(val url: String, val width: Int?, val height: Int?) : Parcelable

@Parcelize
data class User(val id: String?, val name: String? = null) : Parcelable
