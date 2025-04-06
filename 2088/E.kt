fun main() {
    readLine()!!.toInt()
    val s = readLine()!!
    println(if (solve(s)) "Yes" else "No")
}

fun solve(s: String): Boolean {
    val colorToCount = mutableMapOf<Char, Int>()
    for (char in s) {
        colorToCount[char] = colorToCount.getOrDefault(char, 0) + 1
    }
    return s.length == 1 || colorToCount.values.any { it != 1 }
}