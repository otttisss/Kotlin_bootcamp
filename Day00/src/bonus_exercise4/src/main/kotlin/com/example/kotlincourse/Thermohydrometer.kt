package com.example.kotlincourse

import kotlin.math.abs

fun main() {
    println("Choose output mode: (C)elsius, (F)ahrenheit, or (K)elvin")
    val scaleInput = readLine()

    val scale = when (scaleInput) {
        "C" -> "Celsius"
        "F" -> "Fahrenheit"
        "K" -> "Kelvin"
        else -> "Celsius"
    }

    println("Output mode: $scale")
    println("Enter a season - (W)inter or (S)ummer:")
    val seasonInput = readLine()

    val season = when (seasonInput) {
        "W" -> "Winter"
        "S" -> "Summer"
        else -> {
            println("Incorrect input. Please enter (W) for Winter or (S) for Summer:")
            return
        }
    }

    println("Season: $season. Enter a temperature in $scale:")

    var temperatureInput: Float? = null
    while (temperatureInput == null) {
        temperatureInput = readLine()?.toFloatOrNull()

        if (temperatureInput == null) {
            println("Incorrect input. Enter a temperature:")
        }
    }

    val temperatureCelsius = temperatureInput.toDouble()

    fun convertToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }

    fun convertToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    val temperature = when (scale) {
        "Celsius" -> temperatureCelsius
        "Fahrenheit" -> convertToFahrenheit(temperatureCelsius)
        "Kelvin" -> convertToKelvin(temperatureCelsius)
        else -> temperatureCelsius
    }

    val targetTemperature = if (season == "Summer") {
        if (temperature < convertTo(scale, 22.0)) convertTo(scale, 22.0) else convertTo(scale, 25.0)
    } else {
        if (temperature < convertTo(scale, 20.0)) convertTo(scale, 20.0) else convertTo(scale, 22.0)
    }

    val difference = abs(targetTemperature - temperature)

    if ((season == "Summer" && temperature in convertTo(scale, 22.0)..convertTo(scale, 25.0)) ||
        (season == "Winter" && temperature in convertTo(scale, 20.0)..convertTo(scale, 22.0))
    ) {
        println("The temperature is $temperature ˚$scale")
        println("The temperature is comfortable.")
    } else {
        println("The temperature is $temperature ˚$scale")

        val comfortRange =
            "from ${convertTo(scale, if (season == "Summer") 22.0 else 20.0)} to ${
                convertTo(scale, if (season == "Summer") 25.0 else 22.0)
            } ˚$scale."

        println("The comfortable temperature is $comfortRange")
        println("Please, make it ${if (temperature < targetTemperature) "warmer" else "cooler"} by $difference degrees.")
    }
}

fun convertTo(scale: String, value: Double): Double {
    return when (scale) {
        "Celsius" -> value
        "Fahrenheit" -> value * 9 / 5 + 32
        "Kelvin" -> value + 273.15
        else -> value
    }
}
