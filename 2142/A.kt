fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map { it.toInt() }
        println(solve(a))
    }
}

fun solve(a: List<Int>): Int {
    return a.withIndex()
        .groupBy({ it.value }, { it.index })
        .values
        .first { it.size == 1 }
        .first() + 1
}