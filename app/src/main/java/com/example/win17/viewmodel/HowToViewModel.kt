package com.example.win17.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win17.model.HowToModel
import com.example.win17.repository.HowToRepository
import kotlinx.coroutines.launch

class HowToViewModel(private val howToRepository: HowToRepository):ViewModel(){
    init {
        viewModelScope.launch {
            howToRepository.getTips()
        }
    }
    val tips: LiveData<HowToModel>
    get() = howToRepository.tips
}