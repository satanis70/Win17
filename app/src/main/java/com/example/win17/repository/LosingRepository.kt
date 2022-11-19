package com.example.win17.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win17.model.LosingModel
import com.example.win17.retrofit.AviatorApi

class LosingRepository(val aviatorApi: AviatorApi){
    private val losingLiveData = MutableLiveData<LosingModel>()
    val losing: LiveData<LosingModel>
    get() = losingLiveData

    suspend fun getLosing(){
        val call = aviatorApi.getLosing()
        if (call.isSuccessful){
            losingLiveData.postValue(call.body())
        }
    }
}