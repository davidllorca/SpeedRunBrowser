package me.example.davidllorca.speedrunbrowser.ui.games

import android.util.Log
import io.reactivex.schedulers.Schedulers
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import javax.inject.Inject

class GamesPresenter @Inject constructor(private val api: SpeedRunApi) : GamesContract.Presenter {

    private var mView: GamesContract.View? = null

    override fun loadGames() {
        api.getGames()
                .subscribeOn(Schedulers.io())
                .subscribe({ t -> Log.i("TAG", t.gameItems.toString()) })
    }


    override fun bindView(view: GamesContract.View) {
        mView = view
    }

    override fun dropView() {
        mView = null
    }


}
