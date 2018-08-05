package me.example.davidllorca.speedrunbrowser.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Provider of networking classes.
 */
@Module
class NetworkModule {

    private val BASE_URL = "http://www.speedrun.com"

    @Singleton
    @Provides
    internal fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // TODO Set own threading config
                .build()
    }

}