import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t) {
        val s = sc.next()
        println(solve(s))
    }
    sc.close()
}

fun solve(s: String): String {
    val symbols = s.toCharArray()
    val lastPlusIndex = s.lastIndexOf('+')
    val firstMinusIndex = s.indexOf('-')
    val swapped = lastPlusIndex != -1 && firstMinusIndex != -1 && lastPlusIndex > firstMinusIndex
    if (swapped) {
        val temp = symbols[lastPlusIndex]
        symbols[lastPlusIndex] = symbols[firstMinusIndex]
        symbols[firstMinusIndex] = temp
    }
    if (check(symbols)) {
        return if (swapped) {
            String.format("%d %d", firstMinusIndex + 1, lastPlusIndex + 1)
        } else {
            "1 1"
        }
    }
    return "-1"
}

fun check(symbols: CharArray): Boolean {
    var depth = 0
    for (symbol in symbols) {
        if (symbol == '+') {
            depth++
        } else {
            if (depth == 0) {
                return false
            }
            depth--
        }
    }
    return true
}

