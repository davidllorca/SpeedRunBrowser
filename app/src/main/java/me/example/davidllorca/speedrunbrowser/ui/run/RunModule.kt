package me.example.davidllorca.speedrunbrowser.ui.run

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RunModule {

    @ContributesAndroidInjector
    internal abstract fun contributeRunActivity(): RunActivity

    @Binds
    internal abstract fun gamesPresenter(presenter: RunPresenter): RunContract.Presenter
}