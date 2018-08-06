package me.example.davidllorca.speedrunbrowser.ui.run

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_run.*
import me.example.davidllorca.speedrunbrowser.R
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import javax.inject.Inject

class RunActivity : AppCompatActivity(), RunContract.View {

    @Inject
    lateinit var presenter: RunPresenter

    lateinit var targetGame: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run)

        targetGame = intent.getParcelableExtra(EXTRA_GAME)
        if (targetGame == null) {
            finish()
            throw IllegalArgumentException("${RunActivity::class.simpleName} need a Game to be initialized")
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(this)
        presenter.loadRun(targetGame)
        displayGame(targetGame)
    }

    override fun onStop() {
        super.onStop()
        presenter.dropView()
    }

    fun displayGame(game: Game) {
//        iv_game_item_logo.background = game.logo.url // TODO
        tv_run_game_name.text = game.name
    }

    override fun displayRun(run: Run) {
        tv_run_time.text = run.time.toString()
    }

    override fun displayPlayer(user: User) {
        tv_run_player_name.text = user.name
    }

    companion object {
        private const val EXTRA_GAME: String = "game"

        fun getCallingIntent(context: Context, game: Game): Intent {
            return Intent(context, RunActivity::class.java).apply {
                putExtra(EXTRA_GAME, game)
            }
        }
    }
}
