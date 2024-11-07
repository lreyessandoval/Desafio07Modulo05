package com.desafiolatam.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val upperCounterMutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(10)
    private val lowerCounterMutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(10)

    val upperCounterStateFlow: StateFlow<Int> = upperCounterMutableStateFlow.asStateFlow()
    val lowerCounterStateFlow: StateFlow<Int> = lowerCounterMutableStateFlow.asStateFlow()


    fun increaseUpper() {
        if (upperCounterMutableStateFlow.value > 0 && lowerCounterMutableStateFlow.value > 0) {
            upperCounterMutableStateFlow.value += 1
            lowerCounterMutableStateFlow.value -= 1
        }
    }

    fun increaseLower() {
        if (upperCounterMutableStateFlow.value > 0 && lowerCounterMutableStateFlow.value > 0) {
            lowerCounterMutableStateFlow.value += 1
            upperCounterMutableStateFlow.value -= 1
        }
    }

    fun isGameFinished(): Boolean {
        return upperCounterMutableStateFlow.value == 0 || lowerCounterMutableStateFlow.value == 0
    }

    fun resetScores() {
        upperCounterMutableStateFlow.value = 10
        lowerCounterMutableStateFlow.value = 10
    }


}