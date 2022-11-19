package com.example.win17.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.win17.model.LosingModel
import com.example.win17.repository.LosingRepository
import kotlinx.coroutines.launch

class LosingViewModel(private val losingRepository: LosingRepository):ViewModel() {
    init {
        viewModelScope.launch {
            losingRepository.getLosing()
        }
    }
    val losing: LiveData<LosingModel>
    get() = losingRepository.losing
}