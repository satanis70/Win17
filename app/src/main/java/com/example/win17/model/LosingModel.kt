package com.example.win17.model


import com.google.gson.annotations.SerializedName

data class LosingModel(
    @SerializedName("losing ")
    val losing: List<Losing>
)