fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    var inLane = true

    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }

    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 0..size - 2) {
        if (list[i] == p && list[i + 1] == m || list[i] == m && list[i + 1] == p) inLane = false
    }
    println(if (inLane) "YES" else "NO")
}