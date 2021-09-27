fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }

    val number = readLine()!!.toInt()

    println(list.count { it == number })
}