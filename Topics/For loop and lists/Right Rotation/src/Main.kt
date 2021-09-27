fun main() {
    val size = readLine()!!.toInt()
    val list = MutableList(size) { readLine()!!.toInt() }
    val n = readLine()!!.toInt()
    val result = list.subList(size - n.mod(size), size) + list.dropLast(n.mod(size))

    println(result.joinToString(" "))
}