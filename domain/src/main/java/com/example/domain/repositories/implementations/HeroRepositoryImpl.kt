package com.example.domain.repositories.implementations

import com.example.domain.converters.HeroConverterImpl
import com.example.domain.models.Hero
import kotlinx.coroutines.*
import remote.models.HeroApi
import remote.providers.HeroProviderImpl
import java.lang.Exception

// communicate with back and data base

class HeroRepositoryImpl(private val heroConverter: HeroConverterImpl) {
    private val heroProvider: HeroProviderImpl = HeroProviderImpl()

    suspend fun fetchHeroes(): Deferred<List<Hero>> {
        return try {
            val heroes: List<HeroApi> = heroProvider.getHeroesList().await()
            GlobalScope.async {
                heroes.map { hero -> heroConverter.fromApiToUI(model = hero)}
            }

        } catch (e: Exception){
            GlobalScope.async { error(e) }
        }
    }
}