package me.example.davidllorca.speedrunbrowser.ui.run

import io.reactivex.disposables.CompositeDisposable
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.model.Run
import me.example.davidllorca.speedrunbrowser.domain.model.User
import me.example.davidllorca.speedrunbrowser.domain.usecase.RunsUseCase
import me.example.davidllorca.speedrunbrowser.domain.usecase.UserUseCase
import timber.log.Timber
import javax.inject.Inject

class RunPresenter @Inject constructor(
        private val runsUseCase: RunsUseCase,
        private val userUseCase: UserUseCase) : RunContract.Presenter {


    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override var view: RunContract.View? = null
    override var viewState: RunViewState = RunViewState(false, null, null)

    override fun loadRun(game: Game) {
        val params = RunsUseCase.Params(game)

        add(runsUseCase.execute(params)
                .subscribe({ runs: List<Run> ->
                    viewState = RunViewState(loading = false, run = runs.first())
                    view?.displayViewState(viewState)

                    runs.first().player?.id?.run {
                        loadUser(this)
                    }
                }, { error: Throwable -> Timber.e(error) })
        )
    }

    private fun loadUser(userId: String) {
        val params = UserUseCase.Params(userId)

        add(userUseCase.execute(params)
                .subscribe({ user: User ->
                    viewState = viewState.copy(loading = false, player = user)
                    view?.displayViewState(viewState)
                }, { error: Throwable -> Timber.e(error) })
        )
    }

    override fun displayViewState(state: RunViewState) {
        view?.displayViewState(state)
    }

    override fun bindView(view: RunContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
        dispose()
    }

}

data class RunViewState(
        var loading: Boolean,
        var game: Game? = null,
        var run: Run? = null,
        var player: User? = null)
