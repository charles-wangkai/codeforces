class Dsu(val n: Int) {
    val parentOrSizes = IntArray(n) { -1 }

    fun find(a: Int): Int {
        if (parentOrSizes[a] < 0) return a
        parentOrSizes[a] = find(parentOrSizes[a])
        return parentOrSizes[a]
    }

    fun union(a: Int, b: Int) {
        val aLeader = find(a)
        val bLeader = find(b)
        if (aLeader != bLeader) {
            parentOrSizes[aLeader] += parentOrSizes[bLeader]
            parentOrSizes[bLeader] = aLeader
        }
    }

    fun buildLeaderToGroup(): Map<Int, List<Int>> {
        val leaderToGroup = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until n) {
            val leader = find(i)
            leaderToGroup.getOrPut(leader) { mutableListOf() }.add(i)
        }
        return leaderToGroup
    }
}

fun solve(n: Int, fu: IntArray, fv: IntArray, gu: IntArray, gv: IntArray): Int {
    val gDsu = Dsu(n)
    for (i in gu.indices) {
        gDsu.union(gu[i] - 1, gv[i] - 1)
    }

    var result = 0
    val fDsu = Dsu(n)
    for (i in fu.indices) {
        if (gDsu.find(fu[i] - 1) != gDsu.find(fv[i] - 1)) {
            result++
        } else {
            fDsu.union(fu[i] - 1, fv[i] - 1)
        }
    }
    result += fDsu.buildLeaderToGroup().size - gDsu.buildLeaderToGroup().size
    return result
}

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (n, m1, m2) = readLine()!!.split(" ").map { it.toInt() }
        val fu = IntArray(m1)
        val fv = IntArray(m1)
        for (i in 0 until m1) {
            val (u, v) = readLine()!!.split(" ").map { it.toInt() }
            fu[i] = u
            fv[i] = v
        }
        val gu = IntArray(m2)
        val gv = IntArray(m2)
        for (i in 0 until m2) {
            val (u, v) = readLine()!!.split(" ").map { it.toInt() }
            gu[i] = u
            gv[i] = v
        }
        println(solve(n, fu, fv, gu, gv))
    }
}