package com.jeancarlo.myapplication

class Carro(val llantas: Int, val modelo: String, var antigue: Int) {
    constructor(llantas: Int, antigue: Int, modelo: String): this(llantas,modelo,antigue)

    fun agregarAnios(){
        antigue++
    }
}