import java.util.Scanner
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()
        val grid = Array(2) { CharArray(n) }
        for (r in 0..1) {
            val line = sc.next()
            for (c in 0 until n) {
                grid[r][c] = line[c]
            }
        }
        println(solve(grid))
    }
    sc.close()
}

fun solve(grid: Array<CharArray>): Int {
    return IntStream.range(0, grid[0].size - 1)
                .filter { it: Int -> grid[0][it] == grid[0][it + 1] }
                .count()
                .toInt()
}

