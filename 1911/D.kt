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

fun solve(a: IntArray): String {
    a.sort()
    val increasing = mutableListOf<Int>()
    val decreasing = mutableListOf<Int>()
    for (number in a) {
        if (increasing.isEmpty() || increasing[increasing.size - 1] != number) {
            increasing.add(number)
        } else if (decreasing.isEmpty() || decreasing[decreasing.size - 1] != number) {
            decreasing.add(number)
        } else {
            return "NO"
        }
    }
    decreasing.reverse()
    return "YES\n${output(increasing)}\n${output(decreasing)}"
}

fun output(sequence: List<Int>): String {
    return "${sequence.size}\n${sequence.joinToString(" ")}"
}

