fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!
        println(if (solve(n)) "YES" else "NO")
    }
}

fun solve(n: String): Boolean {
    var dp = setOf(0)
    for (c in n) {
        val nextDp = mutableSetOf<Int>()
        for (prev in dp) {
            nextDp.add((prev + (c - '0')) % 9)
            if (c <= '3') {
                nextDp.add((prev + (c - '0') * (c - '0')) % 9)
            }
        }
        dp = nextDp
    }
    return 0 in dp
}