package me.example.davidllorca.speedrunbrowser.ui.run

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.example.davidllorca.speedrunbrowser.di.ActivityScope

@Module
abstract class RunModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeRunActivity(): RunActivity

    @Binds
    internal abstract fun gamesPresenter(presenter: RunPresenter): RunContract.Presenter
}