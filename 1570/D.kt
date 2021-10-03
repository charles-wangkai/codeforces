import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    println(solve(n))
    sc.close()
}

fun solve(n: Int): Int {
    var n = n
    val history: MutableSet<Int> = HashSet()
    while (!history.contains(n)) {
        history.add(n)
        n = f(n)
    }
    return history.size
}

fun f(x: Int): Int {
    var result = x + 1
    while (result % 10 == 0) {
        result /= 10
    }
    return result
}