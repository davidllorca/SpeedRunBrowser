package me.example.davidllorca.speedrunbrowser.ui.games

import me.example.davidllorca.speedrunbrowser.ui.common.BasePresenter
import me.example.davidllorca.speedrunbrowser.ui.common.BaseView


interface GamesContract {

    interface View : BaseView<GamesViewState>

    interface Presenter : BasePresenter<View, GamesViewState> {

        fun loadGames()

    }
}