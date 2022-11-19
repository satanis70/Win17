package com.example.win17.model


import com.google.gson.annotations.SerializedName

data class Howto(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)