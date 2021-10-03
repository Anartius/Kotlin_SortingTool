package sorting

import java.math.BigDecimal
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {

    var sortingType = "natural"
    if (args.contains("-sortingType")) {
        sortingType = args[args.indexOf("-sortingType") + 1]
    }

    when (args[args.indexOf("-dataType") + 1]) {
        "long" -> numbers(sortingType)
        "line" -> line(sortingType)
        else -> words(sortingType)
    }

}

fun numbers(sortingType: String) {
    val inputData = mutableListOf<Int>()

    while (scanner.hasNextInt()) {
        inputData.add(scanner.nextInt())
    }
    println("Total numbers: ${inputData.size}.")
    inputData.sort()

    if (sortingType == "natural") {
        println("Sorted data: ${inputData.joinToString(" ")}")
    } else {
        val intMap = mutableMapOf<Int, Int> ()

        for (elem in inputData) {
            if (!intMap.containsKey(elem)) {
                intMap[elem] = inputData.count { it == elem }
            }
        }

        val sortedMap = mutableMapOf<Int, Int>()
        intMap.entries.sortedBy { it.value }.forEach { sortedMap[it.key] = it.value }

        sortedMap.forEach {
                (k, v) -> println("$k: $v time(s), ${percent(inputData.size,v)}%") }
    }
}

fun line(sortingType: String) {
    val inputData = mutableListOf<String>()
    while (scanner.hasNextLine()) {
        inputData.add(scanner.nextLine())
    }

    println("Total lines: ${inputData.size}.")
    val sortedList = inputData.sorted()

    if (sortingType == "natural") {
        println("Sorted data:")
        sortedList.forEach { println(it) }
    } else {
        val linesMap = mutableMapOf<String, Int>()

        for (elem in sortedList) {
            if (!linesMap.containsKey(elem)) {
                linesMap[elem] = sortedList.count { it == elem }
            }
        }

        val sortedMap = mutableMapOf<String, Int>()
        linesMap.entries.sortedBy { it.value }.forEach { sortedMap[it.key] = it.value }
        sortedMap.forEach {
                (k, v) -> println("$k: $v time(s), ${percent(sortedList.size, v)}%") }
    }
}

fun words(sortingType: String) {

    val inputData = mutableListOf<String>()

    while (scanner.hasNext()) {
        inputData.add(scanner.next())
    }
    println("Total words: ${inputData.size}.")
    inputData.sort()

    if (sortingType == "natural") {
        println("Sorted data: ${inputData.joinToString(" ")}")
    } else {
        val wordsMap = mutableMapOf<String, Int>()
        for (elem in inputData) {
            if (!wordsMap.containsKey(elem)) {
                wordsMap[elem] = inputData.count { it == elem }
            }
        }
        val sortedMap = mutableMapOf<String, Int>()
        wordsMap.entries.sortedBy { it.value }.forEach { sortedMap[it.key] = it.value }
        sortedMap.forEach {
                (k, v) -> println("$k: $v time(s), ${percent(inputData.size, v)}%") }
    }
}

fun percent(total: Int, quantity: Int) : Int {
    return (quantity.toBigDecimal() * BigDecimal(100) / total.toBigDecimal()).toInt()
}