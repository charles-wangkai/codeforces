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
    var index = s.length - 1
    while (s[index] == '0') {
        --index
    }
    return s.substring(0, index)
}

