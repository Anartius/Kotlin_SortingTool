fun main() {
    val numberOfCompanies = readLine()!!.toInt()
    val annualIncomes = mutableListOf<Double>()
    val taxesInPerc = mutableListOf<Double>()

    for (i in 0 until numberOfCompanies) {
        annualIncomes.add(readLine()!!.toDouble())
    }

    for (i in 0 until numberOfCompanies) {
        taxesInPerc.add(readLine()!!.toDouble())
    }

    val taxes = annualIncomes.zip(taxesInPerc) { annual, percentage -> annual * percentage / 100 }.toMutableList()
    println(taxes.indexOf(taxes.maxOrNull()) + 1)
}
