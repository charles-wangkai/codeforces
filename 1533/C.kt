import java.util.*
import kotlin.jvm.JvmStatic
import java.util.function.IntPredicate

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t) {
            sc.nextInt()
            val k = sc.nextInt()
            val s = sc.next()
            println(solve(s, k))
        }
        sc.close()
    }

    fun solve(s: String, k: Int): Int {
        var likeCount = s.chars().filter { ch: Int -> ch == '1'.toInt() }.count().toInt()
        val queue: Queue<Int> = ArrayDeque()
        for (i in 0 until s.length) {
            queue.offer(i)
        }
        var result = 0
        while (likeCount != 0) {
            val index = queue.poll()
            if (s[index] == '1') {
                --likeCount
            }
            ++result
            if (!queue.isEmpty()) {
                for (i in 0 until k - 1) {
                    queue.offer(queue.poll())
                }
            }
        }
        return result
    }