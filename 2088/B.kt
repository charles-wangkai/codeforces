fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine() 
        val s = readLine()!!
        println(solve(s))
    }
}

fun solve(s: String): Long {
    val dashCount = s.count { it == '-' }
    val underscoreCount = s.length - dashCount
    val half = dashCount / 2
    return half.toLong() * (dashCount - half).toLong() * underscoreCount.toLong()
}