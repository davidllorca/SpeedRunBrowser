package me.example.davidllorca.speedrunbrowser.domain.model

import me.example.davidllorca.speedrunbrowser.data.remote.model.GameItem
import me.example.davidllorca.speedrunbrowser.data.remote.model.RunItem
import me.example.davidllorca.speedrunbrowser.data.remote.model.UserItem

/**
 *  Conversion utilities from data layer models to domain layer models
 */

fun Iterable<GameItem>.toGame(): List<Game> = map {
    val name = it.names.international
    val logo = with(it.assets.logo) {
        Logo(this.uri, this.width, this.height)
    }
    Game(it.id, name, logo)
}

fun Iterable<RunItem>.toRun(): List<Run> = map {
    Run(it.id,
            Game(id = it.gameId),
            User(it.players.first().id),
            it.times.realtimeT,
            it.videos.links.first().uri)
}

fun UserItem.toUser(): User = User(id, names.international)