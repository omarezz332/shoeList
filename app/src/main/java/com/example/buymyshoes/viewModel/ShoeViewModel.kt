package com.example.buymyshoes.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buymyshoes.models.ShoeModel
import com.example.buymyshoes.repository.ShoeRepo

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<ArrayList<ShoeModel>>()
    val shoes: LiveData<ArrayList<ShoeModel>>
        get() = _shoes

    init {
        _shoes.value = ShoeRepo().getShoes()
    }
    fun addShoe(shoe :ShoeModel){
        _shoes.value?.add(shoe)
    }


}