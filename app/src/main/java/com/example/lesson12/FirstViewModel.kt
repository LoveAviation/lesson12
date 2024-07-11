package com.example.lesson12

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val _state = MutableStateFlow<State>(State.default)
    val state = _state.asStateFlow()

    fun checkText(text: String){
        viewModelScope.launch {
            if(text.length < 3){
                _state.value = State.error
            }else{
                _state.value = State.ready
            }
        }
    }

    fun loading(){
        viewModelScope.launch {
            _state.value = State.loading
            delay(5000)
            _state.value = State.succes
        }
    }
}