package com.example.kotlincourse

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val x1 = getInput("x1")
    val y1 = getInput("y1")
    val r1 = getInput("r1")
    val x2 = getInput("x2")
    val y2 = getInput("y2")
    val r2 = getInput("r2")

    val distance = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

    when {
        distance < r1 + r2 -> {
            if (distance > kotlin.math.abs(r2 - r1)) {
                println("Result: the circles intersect")
            } else if (distance == kotlin.math.abs(r2 - r1)) {
                println("Result: the circles touch")
            } else {
                println("Result: one circle is inside another")
            }
        }
        distance == r1 + r2 -> {
            println("Result: the circles touch")
        }
        else -> {
            println("Result: the circles do not intersect")
        }
    }
}

fun getInput(prompt: String): Double {
    while (true) {
        print("Input $prompt: ")
        try {
            return readLine()?.toDouble() ?: throw NumberFormatException()
        } catch (e: NumberFormatException) {
            println("Couldn't parse a number. Please, try again")
        }
    }
}
