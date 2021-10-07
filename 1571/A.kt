import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t) {
        val s = sc.next()
        println(solve(s))
    }
    sc.close()
}

fun solve(s: String): Char {
    if (s.chars().distinct().count() == 1L) {
        return s[0]
    }
    if (!s.contains(">")) {
        return '<'
    }
    return if (!s.contains("<")) {
        '>'
    } else '?'
}