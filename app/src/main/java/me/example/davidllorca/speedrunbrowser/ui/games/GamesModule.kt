package me.example.davidllorca.speedrunbrowser.ui.games

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.example.davidllorca.speedrunbrowser.di.ActivityScope

@Module
abstract class GamesModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeGamesActivity(): GamesActivity

    @Binds
    internal abstract fun gamesPresenter(presenter: GamesPresenter): GamesContract.Presenter
}