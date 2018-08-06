package me.example.davidllorca.speedrunbrowser.ui.games

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class GamesModule {

    @ContributesAndroidInjector
    internal abstract fun contributeGamesActivity(): GamesActivity

    @Binds
    internal abstract fun gamesPresenter(presenter: GamesPresenter): GamesContract.Presenter
}