package com.example.tipcalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.ceil

class TipCalculatorViewModel : ViewModel() {
    private val _cost = MutableLiveData<String>()
    val cost: LiveData<String> = _cost

    private val _isAmazing = MutableLiveData<Boolean>(true)
    val isAmazing: LiveData<Boolean> = _isAmazing

    private val _isGood = MutableLiveData<Boolean>(false)
    val isGood: LiveData<Boolean> = _isGood

    private val _isOkay = MutableLiveData<Boolean>(false)
    val isOkay: LiveData<Boolean> = _isOkay

    private val _roundUp = MutableLiveData<Boolean>(false)
    val roundUp: LiveData<Boolean> = _roundUp

    private val _tipAmount = MutableLiveData<Double>()
    val tipAmount: LiveData<Double> = _tipAmount

    fun setBiaya(value: String) {
        _cost.value = value
    }

    fun setAmazing() {
        _isAmazing.value = true
        _isGood.value = false
        _isOkay.value = false
    }

    fun setGood() {
        _isAmazing.value = false
        _isGood.value = true
        _isOkay.value = false
    }

    fun setOkay() {
        _isAmazing.value = false
        _isGood.value = false
        _isOkay.value = true
    }

    fun setRoundUp(value: Boolean) {
        _roundUp.value = value
    }

    fun calculateTip(): Boolean {
        val biayaValue = _cost.value
        if (biayaValue.isNullOrEmpty()) {
            return false
        }

        val biayaNominal = biayaValue.toDoubleOrNull()
        if (biayaNominal == null) {
            return false
        }

        var tip = when {
            _isAmazing.value == true -> biayaNominal * 0.20
            _isGood.value == true -> biayaNominal * 0.18
            _isOkay.value == true -> biayaNominal * 0.15
            else -> biayaNominal * 0.15
        }

        if (_roundUp.value == true) {
            tip = ceil(tip)
        }

        _tipAmount.value = tip
        return true
    }
}