import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()

    for (tc in 0 until t) {
        val a = sc.next()
        val b = sc.next()

        println(solve(a, b))
    }

    sc.close()
}

fun solve(a: String, b: String): String {
    val aValue = toValue(a)
    val bValue = toValue(b)

    return when {
        aValue < bValue -> "<"
        aValue > bValue -> ">"
        else -> "="
    }
}

fun toValue(size: String): Int {
    if (size.equals("M")) return 0
    return if (size.last() == 'L') {
        size.length
    } else {
        -size.length
    }
}