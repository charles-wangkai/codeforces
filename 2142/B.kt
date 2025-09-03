fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val k = readLine()!!.toInt()
        println(solve(k))
    }
}

fun solve(k: Int): Int {
    var result = 0
    repeat(k) {
        result++
        while (result % 3 == 0 || result % 10 == 3) {
            result++
        }
    }
    return result
}