package com.example.buymyshoes.repository

import com.example.buymyshoes.models.ShoeModel

class ShoeRepo {

    //dummy data initialization
    fun getShoes(): ArrayList<ShoeModel> {

        val shoe1 = ShoeModel("ADDIDAS","Running Shoe", "this is the best one")
        val shoe2 = ShoeModel("Nike","Original Shoe", "this is the best one")
        return arrayListOf(shoe1, shoe2, shoe1, shoe2, shoe1,shoe2)

    }
}