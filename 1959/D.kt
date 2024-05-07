import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        sc.nextInt()
        val c = sc.next()[0]
        val s = sc.next()

        println(solve(s, c))
    }

    sc.close()
}

fun solve(s: String, c: Char): Int {
    var result = 0
    val sequence = s + s
    var lastGreenIndex = -1
    for (i in sequence.length - 1 downTo 0) {
        if (sequence[i] == 'g') {
            lastGreenIndex = i
        }
        if (sequence[i] == c && lastGreenIndex != -1) {
            result = maxOf(result, lastGreenIndex - i)
        }
    }

    return result
}

