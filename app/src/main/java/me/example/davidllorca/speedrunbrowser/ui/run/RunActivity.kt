package me.example.davidllorca.speedrunbrowser.ui.run

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_run.*
import me.example.davidllorca.speedrunbrowser.R
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.ui.common.ImageLoader
import javax.inject.Inject

class RunActivity : AppCompatActivity(), RunContract.View {

    @Inject
    lateinit var presenter: RunPresenter

    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var targetGame: Game

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

    override fun displayViewState(state: RunViewState) {
        if (state.loading) {
            // TODO show spinner or similar
        } else {
            if (state.game != null) displayGame(state.game!!)
            if (state.run != null) displayRun(state.run!!)
            if (state.player != null) displayPlayer(state.player!!)
        }
    }

    private fun displayGame(game: Game) {
        tv_run_game_name.text = game.name
        imageLoader.loadImage(game.logo?.url ?: "", iv_run_logo)
    }

    private fun displayRun(run: Run) {
        tv_run_time.text = run.time.toString()
        bt_run_video.setOnClickListener {
            intentVideo(run.videoUrl)
        }
    }

    private fun displayPlayer(user: User) {
        tv_run_player_name.text = user.name
    }

    private fun intentVideo(videoUrl: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(videoUrl)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
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
