fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
        val a = readLine()!!.split(" ").map { it.toInt() }
        val q = readLine()!!.split(" ").map { it.toInt() }
        println(solve(n, a, q))
    }
}

fun solve(n: Int, a: List<Int>, q: List<Int>): String {
    if (q.size == n) {
        return "1".repeat(a.size)
    }
    if (q.size != n - 1) {
        return "0".repeat(a.size)
    }
    val questions = q.toSet()
    val list = (1..n).first { it !in questions }
    return a.map { if (it == list) 1 else 0 }.joinToString("")
}