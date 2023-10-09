package com.example.kotlincourse

import kotlin.math.sqrt

fun main() {
    try {
        print("The grouping order is: ")
        val input = readLine() ?: throw Exception("Invalid input")

        val groupingOrder = getGroupingOrderFromArgs(input)

        println("Enter a number:")
        val input2 = readLine()?.toInt() ?: throw Exception("Invalid input")

        val numberString = input2.toString()
        val setOfNumbers = generateSetOfNumbers(numberString)

        when (groupingOrder) {
            "lower" -> testPrimesLowToHigh(setOfNumbers)
            else -> testPrimesHighToLow(setOfNumbers)
        }

    } catch (e: Exception) {
        println("Result:")
        println(e.message)
    }
}

fun generateSetOfNumbers(number: String): List<String> {
    val setOfNumbers = mutableListOf<String>()
    for (i in 1..number.length) {
        setOfNumbers.add(number.substring(0, i))
    }
    return setOfNumbers
}

fun testPrimesLowToHigh(numbers: List<String>) {
    println("Result:")
    for (num in numbers) {
        if (isPrime(num.toInt())) {
            println("$num - prime")
        } else {
            println(num)
        }
    }
}

fun testPrimesHighToLow(numbers: List<String>) {
    println("Result:")
    for (i in numbers.size - 1 downTo 0) {
        if (isPrime(numbers[i].toInt())) {
            println("${numbers[i]} - prime")
        } else {
            println(numbers[i])
        }
    }
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false
    for (i in 2 until num) {
        if (num % i == 0) return false
    }
    return true
}

fun getGroupingOrderFromArgs(grouping: String): String {
    if (grouping.contains("lower")) return "lower"
    return "higher"
}
