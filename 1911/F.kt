import java.util.*

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

    var result = 0
    var lower = 1
    for (ai in a) {
        if (ai + 1 < lower) {
            continue
        }

        if (ai - 1 >= lower) {
            lower = ai
        } else if (ai >= lower) {
            lower = ai + 1
        } else {
            lower = ai + 2
        }

        result++
    }

    return result
}