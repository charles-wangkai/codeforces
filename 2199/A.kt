fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (k) = readLine()!!.split(" ").map { it.toInt() }
        val (a1, b1) = readLine()!!.split(" ").map { it.toInt() }
        val (a2, b2) = readLine()!!.split(" ").map { it.toInt() }
        println(if (solve(k, a1, b1, a2, b2)) "YES" else "NO")
    }
}

fun solve(k: Int, a1: Int, b1: Int, a2: Int, b2: Int): Boolean {
    val scores1 = listOf(a1, a2, 0)
    val scores2 = listOf(b1, b2, k)

    val totalScore1 = scores1.sum()
    val totalScore2 = scores2.sum()

    return (totalScore2 > totalScore1) ||
           (totalScore2 == totalScore1 &&
            scores2.indices.count { scores2[it] > scores1[it] } >= 2)
}