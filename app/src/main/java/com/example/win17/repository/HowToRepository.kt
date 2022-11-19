package com.example.win17.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.win17.model.HowToModel
import com.example.win17.retrofit.AviatorApi

class HowToRepository(val aviatorApi: AviatorApi){
    private val tipsLiveData = MutableLiveData<HowToModel>()
    val tips: LiveData<HowToModel>
    get() = tipsLiveData

    suspend fun getTips(){
        val call = aviatorApi.getHowTo()
        if (call.isSuccessful){
            tipsLiveData.postValue(call.body())
        }
    }
}