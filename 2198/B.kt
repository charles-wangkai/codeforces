fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (a1, a2, a4, a5) = readLine()!!.split(" ").map { it.toInt() }
        println(solve(a1, a2, a4, a5))
    }
}

fun solve(a1: Int, a2: Int, a4: Int, a5: Int): Int {
    return maxOf(
        computeFibonacciness(a1, a2, a1 + a2, a4, a5),
        computeFibonacciness(a1, a2, a4 - a2, a4, a5),
        computeFibonacciness(a1, a2, a5 - a4, a4, a5)
    )
}

fun computeFibonacciness(a1: Int, a2: Int, a3: Int, a4: Int, a5: Int): Int {
    return (if (a1 + a2 == a3) 1 else 0) +
           (if (a2 + a3 == a4) 1 else 0) +
           (if (a3 + a4 == a5) 1 else 0)
}