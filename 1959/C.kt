import java.util.Scanner
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        sc.nextInt()
        val k = sc.nextInt()
        val s = sc.next()

        println(solve(s, k))
    }

    sc.close()
}

fun solve(s: String, k: Int): Int {
    val letterToCount = mutableMapOf<Char, Int>()
    for (letter in s) {
        letterToCount[letter] = letterToCount.getOrDefault(letter, 0) + 1
    }

    var result = 0
    var k_ = k
    for (c in 'a'..'z') {
        val count1 = letterToCount.getOrDefault(c, 0)
        val count2 = letterToCount.getOrDefault(c.uppercaseChar(), 0)

        result += minOf(count1, count2)

        val extra = minOf(k_, (abs(count1 - count2)) / 2)
        result += extra
        k_ -= extra
    }

    return result
}

