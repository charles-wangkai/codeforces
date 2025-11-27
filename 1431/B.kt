import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    repeat(t) {
        val s = sc.next()
        println(solve(s))
    }

    sc.close()
}

fun solve(s: String): Int {
    var result = 0
    var count = 0
    for (i in 0..s.length) {
        if (i != s.length && s[i] == 'v') {
            ++count
        } else {
            result += count / 2
            if (i != s.length) {
                ++result
            }
            count = 0
        }
    }

    return result
}
