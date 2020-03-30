package com.example.contrpickdota2.activities

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import com.example.contrpickdota2.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contrpickdota2.adapters.HeroAdapter
import com.example.contrpickdota2.models.Hero
import com.example.contrpickdota2.presenters.HeroListPresenter
import com.example.contrpickdota2.views.HeroListView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HeroListView {

    private val mAdapter = HeroAdapter()

    @InjectPresenter
    lateinit var heroListPresenter: HeroListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()

        heroListPresenter.fetchHeroes()
    }

    private fun setupAdapter(){
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerHeroList.layoutManager = layoutManager
        recyclerHeroList.adapter = mAdapter
    }

    // View implementation, very primitive, but work :)

    // Present recyclerHeroList and hide txtHeroListLoading
    override fun presentHeroes(data: List<Hero>) {
        recyclerHeroList.visibility = View.VISIBLE
        txtHeroListLoading.visibility = View.GONE

        mAdapter.setData(newHeroes = data)
    }

    // Hide recycler and present textView Loading...
    override fun presentLoading() {
        recyclerHeroList.visibility = View.GONE
        txtHeroListLoading.visibility = View.VISIBLE
    }


}
