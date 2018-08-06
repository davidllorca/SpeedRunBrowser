package me.example.davidllorca.speedrunbrowser.ui.run

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
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

//        targetGame = intent.getParcelableExtra(EXTRA_GAME) // TODO REMOVE NOTES , Game("k6qqkx6g", "name", null)

        targetGame = Game("k6qqkx6g", "name", null)
        if (targetGame == null) {
            finish()
            throw IllegalArgumentException("${RunActivity::class.simpleName} need a Game to be initialized")
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.bindView(this)
        presenter.loadRun(targetGame)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun displayRun(run: Run) {
        Log.i("TAG", run.toString())
    }

    override fun displayPlayer(user: User) {
        Log.i("TAG", user.toString())
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
