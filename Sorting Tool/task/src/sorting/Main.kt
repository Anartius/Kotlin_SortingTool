package sorting

import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val paramList = listOf("java", "SortingTool", "-dataType", "long", "word", "line",
        "-sortingType", "natural", "byCount")
    val wrongArgs = args.filter { !paramList.contains(it) }.toList()
    val arguments = args.filter { paramList.contains(it) }.toList()
    wrongArgs.forEach { println("\"$it\" is not a valid parameter. It will be skipped.") }
    var arg: String
    val sortingType = if (arguments.contains("-sortingType")) {
        try {
            arg = arguments[arguments.indexOf("-sortingType") + 1]

            if (arg == "natural" || arg == "byCount") {
                arguments[arguments.indexOf("-sortingType") + 1]
            } else {
                println("No sorting type defined!")
                return
            }
        } catch (e: IndexOutOfBoundsException) {
            print("No sorting type defined!")
            return
        }
    } else "natural"

    try {
        arg = arguments[arguments.indexOf("-dataType") + 1]
    } catch (e: IndexOutOfBoundsException) {
        println("No data type defined!")
        return
    }

    when (arg) {
        "long" -> numbersSort(sortingType)
        "line" -> linesSort(sortingType)
        "word" -> wordsSort(sortingType)
        else -> {
            println("No data type defined!")
            return
        }
    }

}

fun numbersSort(sortingType: String) {
    val inputData = mutableListOf<Int>()
    var item: String
    while (scanner.hasNext()) {
        item = scanner.next()
        try{
            inputData.add(item.toInt())
        } catch (e: NumberFormatException) {
            println("\"$item\" is not a long. It will be skipped.")
        }
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

fun linesSort(sortingType: String) {
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

fun wordsSort(sortingType: String) {

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