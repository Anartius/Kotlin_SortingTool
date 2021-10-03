fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    val newMap = userMap.toMutableMap()

    if (newMap.containsKey(login)) {
        println("User with this login is already registered!")
        return newMap
    } else {
        newMap[login] = password
    }
    return newMap
}
