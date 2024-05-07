import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()

    for (tc in 0 until t) {
        val n = sc.nextInt()
        val b = IntArray(n) { sc.nextInt() }

        println(if (solve(b)) "YES" else "NO")
    }
}

fun solve(b: IntArray): Boolean {
    val dp = BooleanArray(b.size + 1)
    dp[0] = true
    for (i in dp.indices) {
        if (i != 0 && i - b[i - 1] - 1 >= 0 && dp[i - b[i - 1] - 1]) {
            dp[i] = true
        }
        if (dp[i] && i != b.size && i + b[i] + 1 < dp.size) {
            dp[i + b[i] + 1] = true
        }
    }

    return dp[dp.lastIndex]
}
