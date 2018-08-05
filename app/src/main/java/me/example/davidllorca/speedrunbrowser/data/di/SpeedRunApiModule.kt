package me.example.davidllorca.speedrunbrowser.data.di

import dagger.Module
import dagger.Provides
import me.example.davidllorca.speedrunbrowser.data.remote.SpeedRunApi
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Provider of APIs.
 */
@Module
class SpeedRunApiModule {

    @Singleton
    @Provides
    fun getSpeedRunApi(retrofit: Retrofit): SpeedRunApi {
        return retrofit
                .create<SpeedRunApi>(SpeedRunApi::class.java)
    }

}