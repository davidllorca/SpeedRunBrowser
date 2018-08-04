package me.example.davidllorca.speedrunbrowser.ui.games

import me.example.davidllorca.speedrunbrowser.data.model.Game
import me.example.davidllorca.speedrunbrowser.ui.common.BasePresenter
import me.example.davidllorca.speedrunbrowser.ui.common.BaseView


interface GamesContract {

    interface View : BaseView<Presenter> {

        fun displayGames(games: List<Game>)

    }

    interface Presenter : BasePresenter<View> {

        fun loadGames()

    }
}