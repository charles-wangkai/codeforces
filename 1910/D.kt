import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()

    for (tc in 0 until t) {
        val n = sc.nextInt()
        val a = IntArray(n) { sc.nextInt() }

        println(if (solve(a)) "YES" else "NO")
    }
}

fun solve(a: IntArray): Boolean {
    val n = a.size
    val leftDp = Array(n) { BooleanArray(2) }
    val rightDp = Array(n) { BooleanArray(2) }

    for (i in 0 until n) {
        if (i == 0) {
            leftDp[i][0] = true
            leftDp[i][1] = true
        } else {
            leftDp[i][0] = (leftDp[i - 1][0] && a[i] > a[i - 1]) || (leftDp[i - 1][1] && a[i] > a[i - 1] + 1)
            leftDp[i][1] = (leftDp[i - 1][0] && a[i] + 1 > a[i - 1]) || (leftDp[i - 1][1] && a[i] + 1 > a[i - 1] + 1)
        }
    }

    for (i in n - 1 downTo 0) {
        if (i == n - 1) {
            rightDp[i][0] = true
            rightDp[i][1] = true
        } else {
            rightDp[i][0] = (rightDp[i + 1][0] && a[i] < a[i + 1]) || (rightDp[i + 1][1] && a[i] < a[i + 1] + 1)
            rightDp[i][1] = (rightDp[i + 1][0] && a[i] + 1 < a[i + 1]) || (rightDp[i + 1][1] && a[i] + 1 < a[i + 1] + 1)
        }
    }

    return (0 until n).any { i ->
        when (i) {
            0 -> rightDp[1][0] || rightDp[1][1]
            n - 1 -> leftDp[n - 2][0] || leftDp[n - 2][1]
            else -> (leftDp[i - 1][0] && rightDp[i + 1][0] && a[i - 1] < a[i + 1])
                || (leftDp[i - 1][0] && rightDp[i + 1][1] && a[i - 1] < a[i + 1] + 1)
                || (leftDp[i - 1][1] && rightDp[i + 1][0] && a[i - 1] + 1 < a[i + 1])
                || (leftDp[i - 1][1] && rightDp[i + 1][1] && a[i - 1] + 1 < a[i + 1] + 1)
        }
    }
}