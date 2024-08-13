package com.example.calci

import java.text.DateFormatSymbols

sealed class CalculatorOperation(val symbols: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
}

