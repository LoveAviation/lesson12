package com.example.lesson12

sealed class State {
    object loading : State()
    object error : State()
    object succes : State()
    object ready: State()
    object default: State()
}