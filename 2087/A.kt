fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        println(solve(a, b, c))
    }
}

fun solve(a: Int, b: Int, c: Int): String {
    val digits = (0 until a).joinToString("") { it.toString() }
    val upper = (0 until b).joinToString("") { (it + 'A'.toInt()).toChar().toString() }
    val lower = (0 until c).joinToString("") { (it + 'a'.toInt()).toChar().toString() }
    return "$digits$upper$lower"
}