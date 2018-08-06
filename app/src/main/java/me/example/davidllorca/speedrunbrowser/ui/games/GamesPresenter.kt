package me.example.davidllorca.speedrunbrowser.ui.games

import io.reactivex.disposables.CompositeDisposable
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.usecase.GamesUseCase
import timber.log.Timber
import javax.inject.Inject

class GamesPresenter @Inject constructor(
        private val useCase: GamesUseCase
) : GamesContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mView: GamesContract.View? = null

    override fun loadGames() {
        add(useCase.execute(NoParams)
                .subscribe({ games -> mView?.displayGames(games) },
                        { error -> Timber.e(error) })
        )
    }

    override fun bindView(view: GamesContract.View) {
        mView = view
    }

    override fun dropView() {
        mView = null
        dispose()
    }

}
