import java.util.Scanner
import java.util.TreeMap

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()
        val a = IntArray(n) { sc.nextInt() }

        println(solve(a))
    }

    sc.close()
}

fun solve(a: IntArray): Long {
    val valueToCount = TreeMap<Int, Int>()
    for (ai in a) {
        valueToCount[ai] = (valueToCount[ai] ?: 0) + 1
    }

    var result: Long = 0
    var sum: Long = 0
    for (count in valueToCount.values) {
        result += count * (count - 1L) * (count - 2) / 6 + count * (count - 1L) / 2 * sum
        sum += count
    }

    return result
}