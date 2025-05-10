fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val a = input[0]
    val x = input[1]
    val y = input[2]
    
    println(solve(a, x, y))
}

fun solve(a: Int, x: Int, y: Int): Int {
    return when {
        x > 0 && x < a && y > 0 && y < a -> 0
        x < 0 || x > a || y < 0 || y > a -> 2
        else -> 1
    }
}