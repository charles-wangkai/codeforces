import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    repeat(t) {
        sc.nextInt()
        val k1 = sc.nextInt()
        val k2 = sc.nextInt()
        val s = sc.next()

        println(solve(s, k1, k2))
    }

    sc.close()
}

fun solve(s: String, k1: Int, k2: Int): Int {
    val c = IntArray(s.length)
    for (i in c.indices) {
        if (s[i] == '1') {
            c[i] = minOf(k1, k2 - (if (i == 0) 0 else c[i - 1]))
        }
    }

    return c.sum()
}
