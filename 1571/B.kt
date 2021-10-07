import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()
        val a = sc.nextInt()
        val va = sc.nextInt()
        val c = sc.nextInt()
        val vc = sc.nextInt()
        val b = sc.nextInt()
        println(solve(n, a, va, c, vc, b))
    }
    sc.close()
}

fun solve(n: Int, a: Int, va: Int, c: Int, vc: Int, b: Int): Int {
    return Math.max(va, vc - (c - b))
}