import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    repeat(t) {
        val n = sc.nextInt()
        val a = IntArray(n)
        for (i in a.indices) {
            a[i] = sc.nextInt()
        }
        println(solve(a))
    }
    sc.close()
}

fun solve(a: IntArray): Int {
    val valueToIndices = mutableMapOf<Int, MutableList<Int>>()
    for (i in a.indices) {
        if (!valueToIndices.containsKey(a[i])) {
            valueToIndices[a[i]] = mutableListOf()
        }
        valueToIndices[a[i]]?.add(i)
    }
    return valueToIndices.values
        .stream()
        .filter { indices -> indices.size == 1 }
        .findAny()
        .get()
        .get(0)
        .plus(1)
}

