package com.example.win17.retrofit

import com.example.win17.model.HowToModel
import com.example.win17.model.LosingModel
import retrofit2.Response
import retrofit2.http.GET

interface AviatorApi {
    @GET("/win17/howto.json")
    suspend fun getHowTo():Response<HowToModel>
    @GET("/win17/losing.json")
    suspend fun getLosing():Response<LosingModel>
}