package me.example.davidllorca.speedrunbrowser.ui.run

import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.ui.common.BasePresenter
import me.example.davidllorca.speedrunbrowser.ui.common.BaseView


interface RunContract {

    interface View : BaseView<RunViewState>

    interface Presenter : BasePresenter<View, RunViewState> {

        fun loadRun(game: Game)

    }
}