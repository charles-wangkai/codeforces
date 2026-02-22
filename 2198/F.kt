fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        val a = readLine()!!.split(" ").map { it.toInt() }
        val b = readLine()!!.split(" ").map { it.toInt() }
        println(solve(a, b, k))
    }
}

fun solve(a: List<Int>, b: List<Int>, k: Int): Long {
    val aToCount = a.groupingBy { it }.eachCount()
    val bToCount = b.groupingBy { it }.eachCount()
    val sorted = (a + b).toSet().sorted()
    var result = 0L
    var buyNum = a.size
    var negativeNum = 0
    for (price in sorted) {
        if (negativeNum <= k) {
            result = maxOf(result, price.toLong() * buyNum)
        }
        negativeNum += aToCount.getOrDefault(price, 0) - bToCount.getOrDefault(price, 0)
        buyNum -= bToCount.getOrDefault(price, 0)
    }
    return result
}