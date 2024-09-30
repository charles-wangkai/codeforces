import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()

        println(solve(n))
    }

    sc.close()
}

fun solve(n: Int): String {
    val result = IntArray(n)
    result[0] = 1
    for (i in 1 until result.size) {
        result[i] = n - i + 1
    }

    return result.joinToString(" ")
}
