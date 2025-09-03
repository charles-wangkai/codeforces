fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val s = readLine()!!
        println(solve(s))
    }
}

fun solve(s: String): String {
    val lowerIndices = ArrayDeque<Int>()
    val upperIndices = ArrayDeque<Int>()

    for (i in s.indices) {
        val c = s[i]
        when {
            c.isLowerCase() -> {
                if (c == 'b') {
                    if (lowerIndices.isNotEmpty()) {
                        lowerIndices.removeLast()
                    }
                } else {
                    lowerIndices.addLast(i)
                }
            }
            c.isUpperCase() -> {
                if (c == 'B') {
                    if (upperIndices.isNotEmpty()) {
                        upperIndices.removeLast()
                    }
                } else {
                    upperIndices.addLast(i)
                }
            }
        }
    }

    val result = StringBuilder()
    while (lowerIndices.isNotEmpty() || upperIndices.isNotEmpty()) {
        if (lowerIndices.isNotEmpty() && (upperIndices.isEmpty() ||
            lowerIndices.first() < upperIndices.first())) {
            result.append(s[lowerIndices.removeFirst()])
        } else {
            result.append(s[upperIndices.removeFirst()])
        }
    }

    return result.toString()
}