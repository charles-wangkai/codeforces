import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val n = sc.nextInt()
        val h = sc.nextInt()
        val b = sc.nextInt()
        val grid = Array(2) { CharArray(n) }
        for (r in grid.indices) {
            val line = sc.next()
            for (c in 0 until n) {
                grid[r][c] = line[c]
            }
        }

        println(solve(grid, h, b))
    }

    sc.close()
}

fun solve(grid: Array<CharArray>, h: Int, b: Int): Long {
    return minOf(computeHunterCost(grid, h), computeBuilderCost(grid, h, b))
}

fun computeHunterCost(grid: Array<CharArray>, h: Int): Long {
    var count = 0
    for (line in grid) {
        for (c in line) {
            if (c == 'W') {
                count++
            }
        }
    }

    return count.toLong() * h
}

fun computeBuilderCost(grid: Array<CharArray>, h: Int, b: Int): Long {
    var sheepC = -1
    for (r in grid.indices) {
        for (c in grid[r].indices) {
            if (grid[r][c] == 'S') {
                sheepC = c
            }
        }
    }

    var leftCount = 0
    var rightCount = 0
    for (r in grid.indices) {
        for (c in grid[r].indices) {
            if (grid[r][c] == 'W') {
                if (c < sheepC) {
                    leftCount++
                } else {
                    rightCount++
                }
            }
        }
    }

    return b + minOf(b.toLong(), leftCount.toLong() * h) + minOf(b.toLong(), rightCount.toLong() * h)
}
