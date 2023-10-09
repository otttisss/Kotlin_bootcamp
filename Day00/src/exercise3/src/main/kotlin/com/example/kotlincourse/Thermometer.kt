package com.example.kotlincourse

import kotlin.math.abs

fun main() {
    println("Choose output mode: (C)elsius, (F)ahrenheit, or (K)elvin")
    val scaleInput = readLine()?.toUpperCase()

    val scale = when (scaleInput) {
        "C" -> "Celsius"
        "F" -> "Fahrenheit"
        "K" -> "Kelvin"
        else -> "Celsius"
    }

    println("Output mode: $scale")
    println("Enter a season - (W)inter or (S)ummer:")
    val seasonInput = readLine()?.toUpperCase()

    val season = when (seasonInput) {
        "W" -> "Winter"
        "S" -> "Summer"
        else -> {
            println("Incorrect input. Please enter (W) for Winter or (S) for Summer:")
            return
        }
    }

    println("Season: $season. Enter a temperature in $scale:")
    val temperatureInput = readLine()?.toFloatOrNull()

    if (temperatureInput != null) {
        val temperature = temperatureInput.toDouble()

        if ((season == "Summer" && temperature in 22.0..25.0) ||
            (season == "Winter" && temperature in 20.0..22.0)
        ) {
            println("The temperature is $temperature ˚$scale")
            println("The temperature is comfortable.")
        } else {
            println("The temperature is $temperature ˚$scale")
            val targetTemperature = if (season == "Summer") {
                if (temperature < 22) 22.0 else 25.0
            } else {
                if (temperature < 20) 20.0 else 22.0
            }

            val difference = abs(targetTemperature - temperature)
            println("The comfortable temperature is from ${if (season == "Summer") 22 else 20} to ${if (season == "Summer") 25 else 22} ˚$scale.")
            println("Please, make it ${if (temperature < targetTemperature) "warmer" else "cooler"} by $difference degrees.")
        }
    } else {
        println("Incorrect input. Enter a temperature:")
    }
}
