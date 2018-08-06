package me.example.davidllorca.speedrunbrowser.ui.games

import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import me.example.davidllorca.speedrunbrowser.domain.common.NoParams
import me.example.davidllorca.speedrunbrowser.domain.usecase.GamesUseCase
import javax.inject.Inject

class GamesPresenter @Inject constructor(
        private val useCase: GamesUseCase
) : GamesContract.Presenter {

    override val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mView: GamesContract.View? = null

    override fun loadGames() {
        add(useCase.execute(NoParams())
                .subscribe({ t -> Log.i("TAG", t.toString()) },
                        { t -> Log.e("TAG", t.printStackTrace().toString()) })
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
