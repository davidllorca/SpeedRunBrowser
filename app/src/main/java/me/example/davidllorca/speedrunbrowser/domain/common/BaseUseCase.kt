package me.example.davidllorca.speedrunbrowser.domain.common

import io.reactivex.Single

interface BaseUseCase<in Params, Results> {

    fun execute(params: Params): Single<Results>

}
