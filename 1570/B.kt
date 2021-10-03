import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val a1 = sc.nextInt()
    val a2 = sc.nextInt()
    val k1 = sc.nextInt()
    val k2 = sc.nextInt()
    val n = sc.nextInt()
    print(solve(a1, a2, k1, k2, n))
    sc.close()
}

fun solve(a1: Int, a2: Int, k1: Int, k2: Int, n: Int): String {
    return String.format("%d %d", computeMinThrown(a1, a2, k1, k2, n), computeMaxThrown(a1, a2, k1, k2, n))
}

fun computeMinThrown(a1: Int, a2: Int, k1: Int, k2: Int, n: Int): Int {
    return Math.max(0, n - (a1 * (k1 - 1) + a2 * (k2 - 1)))
}

fun computeMaxThrown(a1: Int, a2: Int, k1: Int, k2: Int, n: Int): Int {
    return if (k1 > k2) {
        computeMaxThrown(a2, a1, k2, k1, n)
    } else Math.min(a1, n / k1) + Math.max(0, n - k1 * a1) / k2
}