fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        val q = readLine()!!.toInt()
        val ls = IntArray(q)
        val ks = IntArray(q)
        for (i in 0 until q) {
            val (l, k) = readLine()!!.split(" ").map { it.toInt() }
            ls[i] = l
            ks[i] = k
        }
        println(solve(a, ls, ks))
    }
}

fun solve(a: IntArray, ls: IntArray, ks: IntArray): String {
    val n = a.size
    val BIT_NUM = 30
    val nextZeroIndices = Array(BIT_NUM) { IntArray(n) }
    for (b in 0 until BIT_NUM) {
        var nextZeroIndex = n
        for (i in n - 1 downTo 0) {
            if ((a[i] shr b and 1) == 0) {
                nextZeroIndex = i
            }
            nextZeroIndices[b][i] = nextZeroIndex
        }
    }

    val results = IntArray(ls.size)
    for (i in ls.indices) {
        val l = ls[i]
        val k = ks[i]
        if (a[l - 1] < k) {
            results[i] = -1
            continue
        }

        var freeIndex = -1
        var minIndex = l - 1
        var maxIndex = n - 1
        for (b in BIT_NUM - 1 downTo 0) {
            if (minIndex > maxIndex) break
            if ((k shr b and 1) == 1) {
                maxIndex = minOf(maxIndex, nextZeroIndices[b][l - 1] - 1)
            } else {
                val tightBeginIndex = nextZeroIndices[b][l - 1]
                if (tightBeginIndex >= minIndex) {
                    freeIndex = minOf(tightBeginIndex - 1, maxIndex)
                    minIndex = tightBeginIndex
                }
            }
        }

        results[i] = if (minIndex <= maxIndex) maxIndex + 1 else freeIndex + 1
    }

    return results.joinToString(" ")
}