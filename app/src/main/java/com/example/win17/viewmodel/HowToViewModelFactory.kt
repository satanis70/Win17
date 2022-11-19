package com.example.win17.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.win17.repository.HowToRepository

class HowToViewModelFactory(private val howToRepository: HowToRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HowToViewModel(howToRepository) as T
    }
}