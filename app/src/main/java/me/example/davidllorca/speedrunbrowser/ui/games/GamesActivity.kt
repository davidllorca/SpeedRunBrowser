package me.example.davidllorca.speedrunbrowser.ui.games

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import me.example.davidllorca.speedrunbrowser.R
import me.example.davidllorca.speedrunbrowser.data.model.Game
import javax.inject.Inject

class GamesActivity : AppCompatActivity(), GamesContract.View {

    @Inject
    lateinit var presenter: GamesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(this)
        presenter.loadGames()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun displayGames(games: List<Game>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
