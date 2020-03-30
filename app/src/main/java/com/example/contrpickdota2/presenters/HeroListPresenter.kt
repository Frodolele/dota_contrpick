package com.example.contrpickdota2.presenters

import android.os.Handler
import com.example.contrpickdota2.models.Hero
import com.example.contrpickdota2.views.HeroListView
import moxy.InjectViewState
import moxy.MvpPresenter
import kotlin.concurrent.thread

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {

    fun fetchHeroes(){
        viewState.presentLoading()
        // mockData check working capacity without networking

        val handler = Handler()
        thread{
            Thread.sleep(3000)
            val mockData = ArrayList<Hero>()
            mockData.add(Hero(id = 0, title = "Anti-Mage", icon = "", attackType = 0))
            mockData.add(Hero(id = 1, title = "Dark Willow", icon = "", attackType = 1))
            mockData.add(Hero(id = 2, title = "Lion", icon = "", attackType = 1))

            handler.post {
                viewState.presentHeroes(data = mockData)
            }
        }



    }
}