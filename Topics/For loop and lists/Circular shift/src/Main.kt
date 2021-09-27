fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }

    list.add(0, list.last())
    list.removeLast()
    println(list.joinToString(" "))
}