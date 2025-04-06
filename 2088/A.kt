fun solve(n: Int): Int {
    return n - 1
}

fun main() {
    val t = readLine()?.toInt() ?: return
    repeat(t) {
        val n = readLine()?.toInt() ?: return
        println(solve(n))
    }
}