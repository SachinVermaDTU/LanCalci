package com.example.calci

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())


    fun onAction(actions : CalculatorAction){
        when(actions){
            is CalculatorAction.Numbers -> enterNumber(actions.numbers)
            is CalculatorAction.Calculate -> calculate()
            is CalculatorAction.Clear -> clear()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Delete -> delete()
            is CalculatorAction.Operation -> enterOperations(actions.operation)
            is CalculatorAction.ChangeNumeralSystem -> changeNumeralSystem(actions.numeralSystem)
        }
    }
    private fun enterOperations(operation: CalculatorOperation){
        if(state.numbers1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }
    private fun clear(){
        val nS = state.numeralSystem
        state = state.copy( numbers1 = "", numbers2 ="", numeralSystem = nS)
    }
    private fun calculate(){
        val n1 = state.numbers1.toDoubleOrNull()
        val n2 = state.numbers2.toDoubleOrNull()
        if(n1 != null && n2 != null){
            val result  = when(state.operation){
               is CalculatorOperation.Add -> n1+ n2
               is CalculatorOperation.Divide -> n1/n2
               is CalculatorOperation.Multiply -> n1*n2
               is CalculatorOperation.Subtract -> n1 - n2
                null -> TODO()
            }
        state = state.copy(
            numbers1 = result.toString().take(15),
            numbers2 = "",
            operation = null,
            numeralSystem= state.numeralSystem
        )
    }
}
    private fun delete(){
        when{
            state.numbers2.isNotBlank() -> state = state.copy(
                numbers2 = state.numbers2.dropLast(1)
            )
            state.operation != null ->state = state.copy(
                operation = null
            )
             state.numbers1.isNotBlank() -> state = state.copy(
                 numbers1 = state.numbers1.dropLast(1)
             )
        }
    }
    private fun enterDecimal(){
        if(state.operation == null && !state.numbers1.contains(".")
            && state.numbers1.isNotBlank()){
            state = state.copy(
                numbers1 =  state.numbers1 + "."
            )
            return
        }
        else if(!state.numbers2.contains(".") && state.numbers2.isNotBlank()){
            state = state.copy(
                numbers2 = state.numbers2 + "."
            )
        }
    }
    private fun enterNumber(number: Int){
        if(state.operation == null){
            if(state.numbers1.length >= 8){
                return
            }
            state = state.copy(
                numbers1 = state.numbers1 + number
            )
            return
        }
        if(state.numbers2.length >=8){
            return
        }
        state = state.copy(
            numbers2 =  state.numbers2 + number
        )
    }
    private fun changeNumeralSystem(numeralSystem: NumeralSystem) {
        state = state.copy(numeralSystem = numeralSystem)
    }

}