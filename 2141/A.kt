fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        println(solve(a))
    }
}

fun solve(a: IntArray): String {
    val indices = mutableListOf<Int>()
    var minValue = Int.MAX_VALUE
    for (i in a.indices) {
        if (a[i] > minValue) {
            indices.add(i)
        } else {
            minValue = a[i]
        }
    }
    return "${indices.size}\n${indices.map { it + 1 }.joinToString(" ")}"
}