package me.example.davidllorca.speedrunbrowser.ui.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BasePresenter<in T> {

    /**
     * Binds presenter with a view when resumed.
     *
     * @param view the view associated with this presenter
     */
    fun bindView(view: T)

    /**
     * Drops the reference to the view when destroyed
     */
    fun dropView()

    val compositeDisposable: CompositeDisposable

    fun add(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}
