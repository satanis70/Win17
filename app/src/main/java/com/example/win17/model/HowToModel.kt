package com.example.win17.model


import com.google.gson.annotations.SerializedName

data class HowToModel(
    @SerializedName("howto")
    val howto: List<Howto>
)