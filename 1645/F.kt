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
    var a = a
    a = Arrays.stream(a).boxed().sorted().mapToInt { x: Int? -> x!! }.toArray()
    var result = 0
    var lower = 1
    for (ai in a) {
        if (ai + 1 < lower) {
            continue
        }
        lower = if (ai - 1 >= lower) {
            ai
        } else if (ai >= lower) {
            ai + 1
        } else {
            ai + 2
        }
        result++
    }
    return result
}