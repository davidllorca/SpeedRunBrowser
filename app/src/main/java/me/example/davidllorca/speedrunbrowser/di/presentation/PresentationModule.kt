package me.example.davidllorca.speedrunbrowser.di.presentation

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activity: AppCompatActivity) {

    @Provides
    internal fun getActivity(): Activity {
        return activity
    }

}