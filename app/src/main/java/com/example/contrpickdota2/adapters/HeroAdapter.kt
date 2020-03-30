package com.example.contrpickdota2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contrpickdota2.R
import com.example.contrpickdota2.models.Hero
import java.util.*

class HeroAdapter: RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val mHeroList: MutableList<Hero> = LinkedList()

    fun setData(newHeroes: List<Hero>){
        mHeroList.clear()
        mHeroList.addAll(newHeroes)

        // Refill RecyclerView item`s
        notifyDataSetChanged()
    }

    // Create
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_hero, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }

    // Fill
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(model = mHeroList[position])
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        private val txtAttackType: TextView = itemView.findViewById(R.id.txtAttackType)
        private val imgAvatar: ImageView = itemView.findViewById(R.id.imgAvatar)

        fun bind(model: Hero){
            txtTitle.text = model.title


            // bad code because we can`t rembember who is 0, who is 1. Good idea: make enum class
            if (model.attackType == 0){
                txtAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            } else {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }
        }

    }


}