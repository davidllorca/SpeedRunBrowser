package me.example.davidllorca.speedrunbrowser.domain.model


/**
 * Domain classes to represent data(Visual Objects).
 */
data class Game(val id: String?, val name: String? = "name", val logo: Logo? = null)

data class Run(val id: String?, val game: Game?, val playerName: String?, val time: Int?, val videoUrl: String?)

data class Logo(val url: String?, val width: Int?, val height: Int?)

data class User(val id: String?, val name: String?)
