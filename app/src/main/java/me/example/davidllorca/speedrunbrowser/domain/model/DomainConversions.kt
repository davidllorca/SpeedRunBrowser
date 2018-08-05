package me.example.davidllorca.speedrunbrowser.domain.model

import me.example.davidllorca.speedrunbrowser.data.remote.GameItem

/**
 *  Conversion utilities from data layer models to domain layer models
 */

fun Iterable<GameItem>.toGame(): List<Game> = map { Game(it.names?.international, it.assets?.logo?.uri) }