package com.example.win17.model


import com.google.gson.annotations.SerializedName

data class Losing(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)