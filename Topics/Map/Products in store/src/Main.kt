fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var sum = 0
    for (i in shoppingList.indices) {
        if (priceList.containsKey(shoppingList[i])) sum += priceList[shoppingList[i]]!!
    }
    return sum
}