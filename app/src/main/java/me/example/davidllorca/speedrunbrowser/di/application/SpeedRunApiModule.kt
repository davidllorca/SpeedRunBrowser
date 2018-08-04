package me.example.davidllorca.speedrunbrowser.di.application

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

    private val BASE_URL = "http://www.speedrun.com"

    @Singleton
    @Provides
    internal fun getSpeedRunApi(retrofit: Retrofit): SpeedRunApi {
        return retrofit.newBuilder()
                .baseUrl(BASE_URL)
                .build()
                .create<SpeedRunApi>(SpeedRunApi::class.java)
    }
}