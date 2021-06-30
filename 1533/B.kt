import java.util.*
import kotlin.jvm.JvmStatic
import java.util.stream.IntStream
import java.util.function.IntPredicate

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            val n = sc.nextInt()
            val x = IntArray(n)
            for (i in x.indices) {
                x[i] = sc.nextInt()
            }
            println(if (solve(x)) "YES" else "NO")
        }
        sc.close()
    }

    fun solve(x: IntArray): Boolean {
        return IntStream.range(0, x.size - 1).anyMatch { i: Int -> (x[i + 1] - x[i]) % 2 == 0 }
    }