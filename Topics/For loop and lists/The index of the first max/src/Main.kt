fun main() {
    val size = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    for (i in 0 until size) {
        list.add(readLine()!!.toInt())
    }
    print(list.indexOf(list.maxOrNull()))
}