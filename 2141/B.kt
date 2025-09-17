import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    repeat(t) {
        val n = sc.nextInt()
        val m = sc.nextInt()
        val a = IntArray(n) { sc.nextInt() }
        val b = IntArray(m) { sc.nextInt() }
        println(solve(a, b))
    }
    sc.close()
}

fun solve(a: IntArray, b: IntArray): Int {
    val bSet = b.toSet()
    val common = a.count { it in bSet }
    val aDiff = a.size - common
    val bDiff = b.size - common
    return if (aDiff <= bDiff) aDiff * 2 + 1 else bDiff * 2 + 2
}