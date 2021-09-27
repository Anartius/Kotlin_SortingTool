fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }
    var count = 0

    for (i in 1..size - 2) {
        if (list[i - 1] + 1 == list[i] && list[i] + 1 == list[i + 1]) count++
    }
    println(count)
}