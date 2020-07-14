package com.goranm.factoryzadatak3

data class Kocka (
    var isDiceEnabled: Boolean,
    var diceNumber: Int
) {

    fun rollRandomNumber(): Int {
        this.diceNumber = (1..6).random()
        return diceNumber
    }

    fun secondRollCheck(): Int {
        if (!isDiceEnabled){
            return rollRandomNumber()
        } else return this.diceNumber
    }

}