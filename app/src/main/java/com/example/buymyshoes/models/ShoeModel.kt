package com.example.buymyshoes.models

import androidx.databinding.BaseObservable


data class ShoeModel (
    var companyName:String,
    var name:String,
    var description: String
        ): BaseObservable()