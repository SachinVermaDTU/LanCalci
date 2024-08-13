package com.example.calci

sealed class CalculatorAction{
    data class Numbers(val numbers : Int) : CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal: CalculatorAction()
    data class ChangeNumeralSystem(val numeralSystem: NumeralSystem) : CalculatorAction()
}