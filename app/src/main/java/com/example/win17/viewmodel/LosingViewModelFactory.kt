package com.example.win17.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win17.repository.LosingRepository

class LosingViewModelFactory(private val losingRepository: LosingRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LosingViewModel(losingRepository) as T
    }
}