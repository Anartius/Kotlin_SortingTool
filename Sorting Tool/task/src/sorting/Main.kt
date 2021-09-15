package sorting

import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    when(args[args.lastIndex]) {
        "long" -> numbers()
        "line" -> line()
        else -> words()
    }
}

fun numbers() {
    val inputData = mutableListOf<Int>()

    while (scanner.hasNextInt()) {
        inputData.add(scanner.nextInt())
    }
    val max = inputData.maxOf { it }
    val quantity = inputData.count { it == max }
    println("""
        Total numbers: ${inputData.size}.
        The greatest number: $max ($quantity time(s), ${percent(inputData.size, quantity)}%).
    """.trimIndent())
}

fun line() {
    val inputData = mutableListOf<String>()

    while (scanner.hasNextLine()) {
        inputData.add(scanner.nextLine())
    }
    val max = inputData.maxOf { it.length }
    val maxLine = inputData.first { it.length == max }
    val quantity = inputData.count { it.length == max }
    println("""
        Total lines: ${inputData.size}.
        The longest line: 
        $maxLine
        ($quantity time(s), ${percent(inputData.size, quantity)}%).
    """.trimIndent())
}

fun words() {

    val inputData = mutableListOf<String>()

    while (scanner.hasNext()) {
        inputData.add(scanner.next())
    }
    val max = inputData.maxOf { it.length }
    val maxLine = inputData.first { it.length == max }
    val quantity = inputData.count { it.length == max }
    println("""
        Total words: ${inputData.size}.
        The longest word: $maxLine ($quantity time(s), ${percent(inputData.size, quantity)}%).
    """.trimIndent())
}

fun percent(quantity: Int, total: Int) : Int {
    return total * 100 / quantity
}