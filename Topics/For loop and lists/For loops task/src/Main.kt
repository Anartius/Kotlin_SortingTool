fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }

    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    println(if (list.contains(p) && list.contains(m)) "YES" else "NO")
}