fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val cards = Array(n) {
            readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        }
        println(solve(cards))
    }
}

fun solve(cards: Array<IntArray>): String {
    val n = cards.size
    for (c in cards) {
        c.sort()
    }

    val valid = cards.all { c ->
        (0 until c.size - 1).all { i -> c[i + 1] - c[i] == n }
    }

    return if (valid) {
        (0 until n)
            .sortedBy { i -> cards[i][0] }
            .map { (it + 1).toString() }
            .joinToString(" ")
    } else {
        "-1"
    }
}