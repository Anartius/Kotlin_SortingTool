package sorting

import java.io.File
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val paramList = mutableListOf("java", "SortingTool", "-dataType", "long", "word", "line",
        "-sortingType", "natural", "byCount", "-inputFile", "-outputFile")

    var inFileName = ""
    var outFileName = ""
    if (args.contains("-inputFile")) {
        inFileName = args[args.indexOf("-inputFile") + 1]
        paramList.add(inFileName)
    }
    if (args.contains("-outputFile")) {
        outFileName = args[args.indexOf("-outputFile") + 1]
        paramList.add(outFileName)
    }

    val wrongArgs = args.filter { !paramList.contains(it) }.toList()
    val arguments = args.filter { paramList.contains(it) }.toList()

    wrongArgs.forEach { println("\"$it\" is not a valid parameter. It will be skipped.") }

    val sortingType = if (arguments.contains("-sortingType")) {
        try {
            val arg = arguments[arguments.indexOf("-sortingType") + 1]

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

    val dataType = try {
        arguments[arguments.indexOf("-dataType") + 1]
    } catch (e: IndexOutOfBoundsException) {
        println("No data type defined!")
        return
    }
    if (outFileName.isNotEmpty()) File(outFileName).writeText("")

    when (dataType) {
        "long" -> numbersSort(sortingType, inFileName, outFileName)
        "word" -> wordsSort(sortingType, inFileName, outFileName)
        "line" -> linesSort(sortingType, inFileName, outFileName)
        else -> {
            println("No data type defined!")
            return
        }
    }
}

fun numbersSort(sortingType: String, inFileName: String, outFileName: String) {
    val inData = mutableListOf<String>()
    val inputData = mutableListOf<Int>()
    val resultList = mutableListOf<String>()

    if (inFileName.isNotEmpty()) {
        inData.addAll(File(inFileName).readText().split(" ").toList())
    } else {
        while (scanner.hasNext()) {
            inData.add(scanner.next())
        }
    }

    inData.forEach {
        try {
            inputData.add(it.toInt())
        } catch (e: NumberFormatException) {
            println("\"$it\" is not a long. It will be skipped.")
        }
    }
    inputData.sort()

    resultList.add("Total numbers: ${inputData.size}.")

    if (sortingType == "natural") {
        resultList.add("Sorted data: ${inputData.joinToString(" ")}")
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
                (k, v) -> resultList.add("$k: $v time(s), ${percent(inputData.size,v)}%")}
    }

    output(resultList, outFileName)
}

fun wordsSort(sortingType: String, inFileName: String, outFileName: String) {
    val inData = mutableListOf<String>()
    val inputData = mutableListOf<String>()
    val resultList = mutableListOf<String>()

    if (inFileName.isNotEmpty()) {
        inData.addAll(File(inFileName).readText().split(" ").toList())
    } else {
        while (scanner.hasNext()) {
            inputData.add(scanner.next())
        }
    }
    inputData.sort()
    resultList.add("Total words: ${inputData.size}.")

    if (sortingType == "natural") {
        resultList.add("Sorted data: ${inputData.joinToString(" ")}")
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
                (k, v) -> resultList.add("$k: $v time(s), ${percent(inputData.size, v)}%") }
    }

    output(resultList, outFileName)
}

fun linesSort(sortingType: String, inFileName: String, outFileName: String) {
    val inData = mutableListOf<String>()
    val inputData = mutableListOf<String>()
    val resultList = mutableListOf<String>()

    if (inFileName.isNotEmpty()) {
        inData.addAll(File(inFileName).readLines().toList())
    } else {
        while (scanner.hasNextLine()) {
            inputData.add(scanner.nextLine())
        }
    }
    val sortedList = inputData.sorted()

    resultList.add("Total lines: ${inputData.size}.")

    if (sortingType == "natural") {
        resultList.add("Sorted data:")
        resultList.addAll(sortedList)
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
                (k, v) -> resultList.add("$k: $v time(s), ${percent(sortedList.size, v)}%") }
    }

    output(resultList, outFileName)
}

fun percent(total: Int, quantity: Int) : Int {
    return (quantity.toBigDecimal() * BigDecimal(100) / total.toBigDecimal()).toInt()
}

fun output(resultList: MutableList<String>, outFileName: String) {
    if (outFileName.isNotEmpty()) {
        File(outFileName).writeText(resultList.joinToString("\n"))
    } else println(resultList.joinToString("\n"))
}