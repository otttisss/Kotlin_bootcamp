package com.example.kotlincourse

import kotlin.math.abs

fun main() {
    println("Output mode: Celsius")
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

    println("Season: $season. Enter a temperature:")
    val temperatureInput = readLine()?.toFloatOrNull()

    if (temperatureInput != null) {
        val temperatureInCelsius = temperatureInput

        if ((season == "Summer" && temperatureInCelsius in 22.0..25.0) ||
            (season == "Winter" && temperatureInCelsius in 20.0..22.0)
        ) {
            println("The temperature is $temperatureInCelsius ˚C")
            println("The temperature is comfortable.")
        } else {
            println("The temperature is $temperatureInCelsius ˚C")
            val targetTemperature = if (season == "Summer") {
                if (temperatureInCelsius < 22) 22.0 else 25.0
            } else {
                if (temperatureInCelsius < 20) 20.0 else 22.0
            }

            val difference = abs(targetTemperature - temperatureInCelsius)
            println("The comfortable temperature is from ${if (season == "Summer") 22 else 20} to ${if (season == "Summer") 25 else 22} ˚C.")
            println("Please, make it ${if (temperatureInCelsius < targetTemperature) "warmer" else "cooler"} by $difference degrees.")
        }
    } else {
        println("Incorrect input. Enter a temperature:")
    }
}
