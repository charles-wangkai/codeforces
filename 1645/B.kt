import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    sc.nextInt()
    val s = sc.next()
    println(solve(s))
    sc.close()
}

fun solve(s: String): String {
    val result = StringBuilder()
    var index = 0
    var step = 1
    while (index < s.length) {
        result.append(s[index])
        index += step
        step++
    }
    return result.toString()
}