package me.example.davidllorca.speedrunbrowser.ui.games

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_games.*
import me.example.davidllorca.speedrunbrowser.R
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.ui.common.ImageLoader
import me.example.davidllorca.speedrunbrowser.ui.run.RunActivity
import javax.inject.Inject

class GamesActivity : AppCompatActivity(), GamesContract.View, GamesAdapter.Listener {

    @Inject
    lateinit var presenter: GamesPresenter

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        rv_games_list.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = GamesAdapter(emptyList(), this, this, imageLoader)
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(this)
        presenter.loadGames()
    }

    override fun onStop() {
        super.onStop()
        presenter.dropView()
    }

    override fun displayViewState(state: GamesViewState) {
        if (state.loading) {
            // TODO show spinner or similar
        } else {
            (rv_games_list.adapter as GamesAdapter).setGames(state.games)
        }
    }

    override fun onClickGame(game: Game) {
        RunActivity.getCallingIntent(this, game)
                .let { startActivity(it) }
    }
}
