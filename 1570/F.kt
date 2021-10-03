import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

val R_OFFSETS = intArrayOf(-1, -1, 0, 0)
val C_OFFSETS = intArrayOf(-1, 0, -1, 0)
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val A = Array(n) { IntArray(m) }
    for (r in 0 until n) {
        for (c in 0 until m) {
            A[r][c] = sc.nextInt()
        }
    }
    print(solve(A))
    sc.close()
}

fun solve(A: Array<IntArray>): String {
    val n = A.size
    val m: Int = A[0].size
    val operations: MutableSet<String> = HashSet()
    for (r in 0 until n) {
        for (c in 0 until m) {
            if (A[r][c] == 1) {
                val operation = findOperation(A, r, c) ?: return "-1"
                operations.add(operation)
            }
        }
    }
    return String.format(
        "%d\n%s", operations.size,
        operations.stream().map { obj: String -> obj }.collect(Collectors.joining("\n"))
    )
}

fun findOperation(A: Array<IntArray>, r: Int, c: Int): String? {
    val n = A.size
    val m: Int = A[0].size
    for (i in R_OFFSETS.indices) {
        val x = r + R_OFFSETS[i]
        val y = c + C_OFFSETS[i]
        if (x >= 0 && x < n && y >= 0 && y < m && IntStream.range(0, R_OFFSETS.size).allMatch { j: Int ->
                val adjR = x - R_OFFSETS[j]
                val adjC = y - C_OFFSETS[j]
                adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && A[adjR][adjC] == 1
            }) {
            return String.format("%d %d", x + 1, y + 1)
        }
    }
    return null
}