package com.example.kotlincourse

import kotlin.math.sqrt

fun main() {
    try {
        println("Enter a number:")
        val input = readLine()?.toInt() ?: throw Exception("Invalid input")

        val numberString = input.toString()
        val setOfNumbers = generateSetOfNumbers(numberString)

        val groupingOrder = getGroupingOrderFromArgs()

        when (groupingOrder) {
            "higher" -> testPrimesHighToLow(setOfNumbers)
            else -> testPrimesLowToHigh(setOfNumbers)
        }

    } catch (e: Exception) {
        println("Result:")
        println(e.message)
    }
}

fun generateSetOfNumbers(number: String): List<String> {
    val setOfNumbers = mutableListOf<String>()
    for (i in number.indices) {
        setOfNumbers.add(number.substring(i))
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
    if (num <= 1) return false
    if (num == 2) return true
    if (num % 2 == 0) return false
    val sqrtNum = sqrt(num.toDouble()).toInt() + 1
    for (i in 3 until sqrtNum step 2) {
        if (num % i == 0) return false
    }
    return true
}

fun getGroupingOrderFromArgs(): String {
    val args = System.getProperty("sun.java.command").split(" ").toTypedArray()
    if (args.contains("higher")) return "higher"
    return "lower"
}
