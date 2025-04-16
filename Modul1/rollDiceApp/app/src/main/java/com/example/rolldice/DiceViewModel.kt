package com.example.rolldice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    private val _dice1Result = MutableLiveData<Int>()
    val dice1Result: LiveData<Int> = _dice1Result

    private val _dice2Result = MutableLiveData<Int>()
    val dice2Result: LiveData<Int> = _dice2Result

    private val _isDouble = MutableLiveData<Boolean>()
    val isDouble: LiveData<Boolean> = _isDouble

    class Dice(private val jumlahSisi: Int) {
        fun roll(): Int {
            return (1..jumlahSisi).random()
        }
    }

    fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        _dice1Result.value = dice1Roll
        _dice2Result.value = dice2Roll
        _isDouble.value = dice1Roll == dice2Roll
    }
}