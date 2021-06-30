import java.util.*
import kotlin.jvm.JvmStatic
import java.util.stream.IntStream
import java.util.function.IntPredicate
import java.util.function.IntUnaryOperator

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            val n = sc.nextInt()
            val k = sc.nextInt()
            val l = IntArray(n)
            val r = IntArray(n)
            for (i in 0 until n) {
                l[i] = sc.nextInt()
                r[i] = sc.nextInt()
            }
            println(solve(l, r, k))
        }
        sc.close()
    }

    fun solve(l: IntArray, r: IntArray, k: Int): Int {
        val maxRight = IntStream.range(0, l.size).filter { i: Int -> l[i] <= k }.map { i: Int -> r[i] }.max()
        return if (maxRight.isPresent) Math.max(0, maxRight.asInt - k + 1) else 0
    }