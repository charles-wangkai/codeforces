fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine() // skip integer n
        val s = readLine()!!
        println(solve(s))
    }
}

fun solve(s: String): Int {
    val letterToCount = s.groupingBy { it }.eachCount()
    val maxCount = letterToCount.values.maxOrNull() ?: 0
    val otherCount = s.length - maxCount
    return if (maxCount < otherCount) {
        (otherCount - maxCount) % 2
    } else {
        maxCount - otherCount
    }
}