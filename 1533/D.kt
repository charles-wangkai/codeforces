import java.util.*
import java.util.function.Function
import kotlin.jvm.JvmStatic
import java.util.stream.IntStream
import java.util.stream.Collectors
import java.util.function.ToIntFunction
import java.util.function.IntFunction

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val m = sc.nextInt()
        val s = arrayOfNulls<String>(n)
        for (i in s.indices) {
            s[i] = sc.next()
        }
        val q = sc.nextInt()
        val t = arrayOfNulls<String>(q)
        for (i in t.indices) {
            t[i] = sc.next()
        }
        println(solve(s, m, t))
        sc.close()
    }

    fun solve(s: Array<String?>, m: Int, t: Array<String?>?): String {
        val strToIndex = IntStream.range(0, s.size)
            .boxed()
            .collect(Collectors.toMap(Function { i: Int? -> s[i!!] }, Function { i: Int? -> i }))
        return Arrays.stream(t)
            .mapToInt { ti: String? ->
                val indices: MutableSet<Int?> = HashSet()
                for (i in 0..m) {
                    val removed = String.format("%s%s", ti!!.substring(0, i), ti.substring(i + 1))
                    if (strToIndex.containsKey(removed)) {
                        indices.add(strToIndex[removed])
                    }
                }
                indices.size
            }
            .mapToObj { i: Int -> i.toString() }
            .collect(Collectors.joining("\n"))
    }