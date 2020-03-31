package com.example.domain.converters

import com.example.domain.models.Hero
import remote.models.HeroApi


// Converts HeroApi to Hero so that data from the data block can be sent to the UI layer
class HeroConverterImpl {
    fun fromApiToUI(model: HeroApi): Hero{
        fun attackTypeInt(): Int = if (model.attack_type == "Melee") { 0 } else { 1 }

        return Hero(id = model.id, title = model.name.replace("npc_dota_hero_", ""), attackType = attackTypeInt(), icon = "")
    }
}