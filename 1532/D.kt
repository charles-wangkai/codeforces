import java.util.*
import kotlin.jvm.JvmStatic
import java.util.stream.IntStream
import java.util.function.IntPredicate
import java.util.function.IntUnaryOperator

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val a = IntArray(n)
        for (i in a.indices) {
            a[i] = sc.nextInt()
        }
        println(solve(a))
        sc.close()
    }

    fun solve(a: IntArray): Int {
        Arrays.sort(a)
        return IntStream.range(0, a.size).filter { i: Int -> i % 2 == 0 }.map { i: Int -> a[i + 1] - a[i] }.sum()
    }