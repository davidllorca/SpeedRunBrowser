package me.example.davidllorca.speedrunbrowser.di.application

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

    @Singleton
    @Provides
    internal fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // TODO Set own threading config
                .build()
    }

}