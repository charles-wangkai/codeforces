import java.util.Scanner
import java.util.stream.Collectors
import java.util.stream.IntStream

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val s = sc.next()
        println(solve(s))
    }

    sc.close()
}

fun solve(s: String): String {
    val indices = IntStream.range(0, s.length)
        .filter { i -> (s[i] - s[0]) * (s[i] - s[s.length - 1]) <= 0 }
        .boxed()
        .sorted { i1, i2 -> Math.abs(s[i1] - s[0]).compareTo(Math.abs(s[i2] - s[0])) }
        .mapToInt { it }
        .toArray()

    return "${Math.abs(s[0] - s[s.length - 1])} ${indices.size}\n${indices.map { it + 1 }.joinToString(" ")}"
}

