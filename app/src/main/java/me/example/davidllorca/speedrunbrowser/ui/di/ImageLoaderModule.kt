package me.example.davidllorca.speedrunbrowser.ui.di

import dagger.Module
import dagger.Provides
import me.example.davidllorca.speedrunbrowser.ui.common.ImageLoader

@Module
class ImageLoaderModule {

    @Provides
    fun getImageLoader(): ImageLoader {
        return ImageLoader()
    }
}