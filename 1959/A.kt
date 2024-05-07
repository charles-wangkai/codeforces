import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()
        val a = IntArray(n) { sc.nextInt() }

        println(solve(a))
    }

    sc.close()
}

fun solve(a: IntArray): Int {
    val valueToIndices = mutableMapOf<Int, MutableList<Int>>()
    for (i in a.indices) {
        if (valueToIndices[a[i]] == null) {
            valueToIndices[a[i]] = mutableListOf()
        }
        valueToIndices[a[i]]?.add(i)
    }

    return valueToIndices.values.firstOrNull { it.size == 1 }?.get(0)?.plus(1) ?: 0
}

