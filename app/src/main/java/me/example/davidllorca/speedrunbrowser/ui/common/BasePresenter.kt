package me.example.davidllorca.speedrunbrowser.ui.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BasePresenter<View, ViewState> {

    var view: View?
    var viewState: ViewState

    /**
     * Binds presenter with a view when resumed.
     *
     * @param view the view associated with this presenter
     */
    fun bindView(view: View)

    /**
     * Drops the reference to the view when destroyed.
     */
    fun dropView()

    /**
     * Notify to view associated current view state.
     */
    fun displayViewState(viewState: ViewState)

    val compositeDisposable: CompositeDisposable

    fun add(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}
