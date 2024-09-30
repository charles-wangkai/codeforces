import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val s = sc.next()

        println(solve(s))
    }

    sc.close()
}

fun solve(s: String): Long {
    val parts = s.split("+")
    
    var result = parts[0].toLong() + parts[parts.size - 1].toLong()
    for (i in 1 until parts.size - 1) {
        var maxSum = 0L
        for (leftLength in 1 until parts[i].length) {
            maxSum = maxOf(
                maxSum,
                parts[i].substring(0, leftLength).toLong() + parts[i].substring(leftLength).toLong()
            )
        }

        result += maxSum
    }

    return result
}
