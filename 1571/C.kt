import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt()
    for (tc in 0 until T) {
        val n = sc.nextInt()
        val s = arrayOfNulls<String>(n)
        val t = arrayOfNulls<String>(n)
        val r = IntArray(n)
        for (i in 0 until n) {
            s[i] = sc.next()
            t[i] = sc.next()
            r[i] = sc.nextInt()
        }
        println(solve(s, t, r))
    }
    sc.close()
}

fun solve(s: Array<String?>, t: Array<String?>, r: IntArray): String {
    var min = 0
    var max = Int.MAX_VALUE
    for (i in s.indices) {
        var suffix = 0
        while (s[i]!!.length >= suffix + 1 && t[i]!!.length >= suffix + 1 && s[i]!![s[i]!!.length - 1 - suffix] == t[i]!![t[i]!!.length - 1 - suffix]) {
            ++suffix
        }
        if (r[i] == 1) {
            max = Math.min(max, suffix)
        } else {
            min = Math.max(min, suffix + 1)
        }
    }
    return if (min > max) {
        "0"
    } else String.format(
        "%d\n%s",
        max - min + 1,
        IntStream.rangeClosed(min, max).mapToObj { i: Int -> i.toString() }.collect(Collectors.joining(" "))
    )
}