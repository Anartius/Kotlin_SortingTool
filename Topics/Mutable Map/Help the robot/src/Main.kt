fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
    val result = purchases.toMutableMap()

    for (key in addition.keys) {
        result[key] = if (result.containsKey(key)) {
            result.getValue(key) + addition.getValue(key)
        } else addition.getValue(key)
    }

    return result
}
