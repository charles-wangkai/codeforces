import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t) {
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
    val valueToIndices: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in a.indices) {
        if (!valueToIndices.containsKey(a[i])) {
            valueToIndices[a[i]] = ArrayList()
        }
        valueToIndices[a[i]]!!.add(i)
    }
    return (valueToIndices.values.stream()
        .filter { indices: List<Int> -> indices.size == 1 }
        .findAny()
        .get()[0]
            + 1)
}