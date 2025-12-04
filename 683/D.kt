import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val q = sc.nextInt()
    repeat(q) {
        val n = sc.nextInt()
        val m = sc.nextInt()
        val p = sc.nextInt()

        println(if (solve(n, m, p)) "Yes" else "No")
    }

    sc.close()
}

fun solve(n: Int, m: Int, p: Int): Boolean {
    return (1..n).any { i -> p % i == 0 && p / i <= m }
}
