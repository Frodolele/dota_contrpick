package com.example.contrpickdota2.presenters

import com.example.contrpickdota2.views.HeroListView
import com.example.domain.converters.HeroConverterImpl
import com.example.domain.repositories.implementations.HeroRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import java.lang.Exception

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {

    private val heroesRepositoryImpl = HeroRepositoryImpl(heroConverter = HeroConverterImpl())

    fun fetchHeroes(){
        viewState.presentLoading()

        GlobalScope.launch(Dispatchers.IO){
            try {
                val heroes = heroesRepositoryImpl.fetchHeroes().await()

                withContext(Dispatchers.Main){
                    viewState.presentHeroes(data = heroes)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}