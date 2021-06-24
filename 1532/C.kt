import java.util.*
import kotlin.jvm.JvmStatic
import java.util.stream.IntStream
import java.util.function.IntFunction
import java.util.stream.Collectors

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            val n = sc.nextInt()
            val k = sc.nextInt()
            println(solve(n, k))
        }
        sc.close()
    }

    fun solve(n: Int, k: Int): String {
        return IntStream.range(0, n)
            .mapToObj(IntFunction<String> { i: Int -> (i % k + 'a'.toInt()).toChar().toString() })
            .collect(Collectors.joining())
    }