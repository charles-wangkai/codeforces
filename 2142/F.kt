fun main() {
    val input = generateSequence(::readLine)
        .flatMap { it.split(" ") }
        .iterator()
    fun nextInt() = input.next().toInt()
    
    val t = nextInt()
    repeat(t) {
        val n = nextInt()
        val m = nextInt()
        val a = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                a[r][c] = nextInt()
            }
        }
        val b = Array(n) { IntArray(m) }
        for (r in 0 until n) {
            for (c in 0 until m) {
                b[r][c] = nextInt()
            }
        }
        println(if (solve(a, b)) "YES" else "NO")
    }
}

fun solve(a: Array<IntArray>, b: Array<IntArray>): Boolean {
    val n = a.size
    val m = a[0].size

    val valueToOldR = mutableMapOf<Int, Int>()
    val valueToOldC = mutableMapOf<Int, Int>()
    for (r in 0 until n) {
        for (c in 0 until m) {
            valueToOldR[a[r][c]] = r
            valueToOldC[a[r][c]] = c
        }
    }

    val rMapping = mutableMapOf<Int, Int>()
    for (r in 0 until n) {
        val key = valueToOldR[b[r][0]] ?: return false
        if (rMapping.containsKey(key)) return false
        rMapping[key] = r
    }

    val cMapping = mutableMapOf<Int, Int>()
    for (c in 0 until m) {
        val key = valueToOldC[b[0][c]] ?: return false
        if (cMapping.containsKey(key)) return false
        cMapping[key] = c
    }

    for (r in 0 until n) {
        for (c in 0 until m) {
            val newRow = rMapping[r] ?: return false
            val newCol = cMapping[c] ?: return false
            if (b[newRow][newCol] != a[r][c]) return false
        }
    }

    return true
}