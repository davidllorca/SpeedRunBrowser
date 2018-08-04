package me.example.davidllorca.speedrunbrowser.ui.common

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

}
