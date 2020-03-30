package com.example.contrpickdota2.views

import com.example.contrpickdota2.models.Hero
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface HeroListView: MvpView {
    fun presentHeroes(data: List<Hero>)
    fun presentLoading()
}