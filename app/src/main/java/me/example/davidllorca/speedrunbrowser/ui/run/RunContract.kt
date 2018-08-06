package me.example.davidllorca.speedrunbrowser.ui.run

import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.ui.common.BasePresenter
import me.example.davidllorca.speedrunbrowser.ui.common.BaseView


interface RunContract {

    interface View : BaseView<Presenter> {

        fun displayRun(run: Run)

        fun displayPlayer(user: User)

    }

    interface Presenter : BasePresenter<View> {

        fun loadRun(game: Game)

    }
}