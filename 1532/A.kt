import java.util.*
import kotlin.jvm.JvmStatic

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            println(solve(a, b))
        }
        sc.close()
    }

    fun solve(a: Int, b: Int): Int {
        return a + b
    }