package sorting

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val inputData = mutableListOf<Int>()
    while (scanner.hasNextInt()) {
        inputData.add(scanner.nextInt())
    }
    val max = inputData.maxOf { it }
    val quantity = inputData.count { it == max }
    println("""
        Total numbers: ${inputData.size}
        The greatest number: $max ($quantity time(s)).
    """.trimIndent())
}