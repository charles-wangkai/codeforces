fun main() {
    val input = generateSequence(::readLine)
        .flatMap { it.split(" ") }
        .iterator()
    fun nextInt() = input.next().toInt()

    val t = nextInt()
    repeat(t) {
        val a = nextInt()
        val b = nextInt()
        val c = nextInt()
        val d = nextInt()
        println(solve(a, b, c, d))
    }
}

fun solve(a: Int, b: Int, c: Int, d: Int): Int {
    return (c - a) + (d - b) - maxOf(0, minOf(c, d) - maxOf(a, b))
}