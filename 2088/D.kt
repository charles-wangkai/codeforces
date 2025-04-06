fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val input = readLine()!!.split(" ")
        val n = input[0].toInt()
        val x = input[1].toLong()
        val y = input[2].toLong()
        val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        println(solve(a, x, y))
    }
}

fun solve(a: IntArray, x: Long, y: Long): Long {
    a.sort()

    val sum = a.sumOf { it.toLong() }
    var result = 0L
    var beginIndex = a.size
    var endIndex = a.size - 1

    for (i in a.size - 2 downTo 0) {
        beginIndex--
        while (beginIndex != a.size && a[i].toLong() + a[beginIndex].toLong() < sum - y) {
            beginIndex++
        }

        endIndex--
        while (endIndex != a.size - 1 && a[i].toLong() + a[endIndex + 1].toLong() <= sum - x) {
            endIndex++
        }

        result += kotlin.math.max(0, endIndex - beginIndex + 1)
    }
    return result
}