package me.example.davidllorca.speedrunbrowser.ui.games

import io.reactivex.disposables.CompositeDisposable
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.model.Game
import me.example.davidllorca.speedrunbrowser.domain.usecase.GamesUseCase
import timber.log.Timber
import javax.inject.Inject

class GamesPresenter @Inject constructor(
        private val useCase: GamesUseCase
) : GamesContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override var view: GamesContract.View? = null
    override var viewState: GamesViewState = GamesViewState(false, listOf())

    override fun loadGames() {
        add(useCase.execute(NoParams)
                .subscribe({ games ->
                    viewState = viewState.copy(false, games)
                    displayViewState(viewState)
                }, { error -> Timber.e(error) })
        )
    }

    override fun displayViewState(state: GamesViewState) {
        view?.displayViewState(state)
    }

    override fun bindView(view: GamesContract.View) {
        this.view = view
    }

    override fun dropView() {
        view = null
        dispose()
    }

}

data class GamesViewState(
        var loading: Boolean,
        var games: List<Game>)