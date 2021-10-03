fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    var key: String
    var value: Int

    while (true) {
        key = readLine()!!
        if (key == "stop") break
        value = readLine()!!.toInt()
        if (!studentsMarks.containsKey(key)) studentsMarks[key] = value
    }

    println(studentsMarks)

}