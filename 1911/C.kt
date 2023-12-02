import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in a.indices) {
        a[i] = sc.nextInt()
    }
    println(solve(a))
    sc.close()
}

fun solve(a: IntArray): Int {
    a.sort()
    return IntRange(0, a.size - 1).filter { it % 2 == 0 }.map { a[it + 1] - a[it] }.sum()
}

