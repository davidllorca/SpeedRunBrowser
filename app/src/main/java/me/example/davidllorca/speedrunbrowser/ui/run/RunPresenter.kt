package me.example.davidllorca.speedrunbrowser.ui.run

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.domain.usecase.RunsUseCase
import me.example.davidllorca.speedrunbrowser.domain.usecase.UserUseCase
import javax.inject.Inject

class RunPresenter @Inject constructor(
        private val runsUseCase: RunsUseCase,
        private val userUseCase: UserUseCase) : RunContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mView: RunContract.View? = null

    override fun loadRun(game: Game) {
        val params = RunsUseCase.Params(game)

        add(runsUseCase.execute(params)
                .subscribe({ runs: List<Run> ->
                    mView?.displayRun(runs.first())
                    loadUser(runs.first())
                }, { error: Throwable -> Log.e("TAG", error.printStackTrace().toString()) })
        )
    }

    private fun loadUser(targetRun: Run) {
        val params = UserUseCase.Params(targetRun.player?.id!!) // TODO fix nullability

        add(userUseCase.execute(params)
                .subscribe({ user: User? -> mView?.displayPlayer(user!!) },
                        { error: Throwable -> Log.e("TAG", error.printStackTrace().toString()) }) // TODO FIX NULLABILITIES
        )
    }

    override fun bindView(view: RunContract.View) {
        mView = view
    }

    override fun dropView() {
        mView = null
        dispose()
    }

}
