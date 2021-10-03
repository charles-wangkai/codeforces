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

fun solve(s: String): Int {
    val leftIndex = s.indexOf('1')
    return if (leftIndex == -1) {
        0
    } else s.substring(leftIndex, s.lastIndexOf('1') + 1).chars().filter { ch: Int -> ch == '0'.toInt() }.count()
        .toInt()
}