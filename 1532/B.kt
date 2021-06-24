import java.util.*
import kotlin.jvm.JvmStatic

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val k = sc.nextInt()
            println(solve(a, b, k))
        }
        sc.close()
    }

    fun solve(a: Int, b: Int, k: Int): Long {
        return (a - b).toLong() * (k / 2) + if (k % 2 == 0) 0 else a
    }