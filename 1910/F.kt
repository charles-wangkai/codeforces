import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()

    for (tc in 0 until t) {
        val n = sc.nextInt()
        val k = sc.nextInt()
        val v = IntArray(n - 1)
        val u = IntArray(n - 1)
        for (i in 0 until n - 1) {
          v[i] = sc.nextInt()
          u[i] = sc.nextInt()
        }

        println(solve(v, u, k))
    }
}

fun solve(v: IntArray, u: IntArray, k: Int): Long {
    val n = v.size + 1
    val adjLists = Array(n) { mutableListOf<Int>() }

    for (i in v.indices) {
        adjLists[v[i] - 1].add(u[i] - 1)
        adjLists[u[i] - 1].add(v[i] - 1)
    }

    val frequencies = mutableListOf<Long>()
    search(adjLists, frequencies, -1, 0)

    val sorted = frequencies.sortedDescending().toLongArray()

    return (0 until sorted.size).map { it: Int -> (if (it < k - 1) 1 else 2) * sorted[it] } .sum()
}

fun search(adjLists: Array<MutableList<Int>>, frequencies: MutableList<Long>, parent: Int, node: Int): Int {
    var result = 1
    for (adj in adjLists[node]) {
        if (adj != parent) {
            result += search(adjLists, frequencies, node, adj)
        }
    }

    frequencies.add((result.toLong() * (adjLists.size - result)))

    return result
}
