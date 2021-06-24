import java.util.*
import kotlin.jvm.JvmStatic
import java.util.stream.Collectors

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val a = IntArray(n)
        for (i in a.indices) {
            a[i] = sc.nextInt()
        }
        print(solve(a))
        sc.close()
    }

    fun solve(a: IntArray): String {
        val total = Arrays.stream(a).asLongStream().sum()
        val valueToCount: MutableMap<Long, Int> = HashMap()
        for (value in a) {
            updateValueToCount(valueToCount, value.toLong(), 1)
        }
        val niceIndices: MutableList<Int> = ArrayList()
        for (i in a.indices) {
            val remainSum = total - a[i]
            if (remainSum % 2 == 0L && valueToCount.getOrDefault(
                    remainSum / 2,
                    0
                ) >= if (a[i].toLong() == remainSum / 2) 2 else 1
            ) {
                niceIndices.add(i + 1)
            }
        }
        return String.format("%d\n%s", niceIndices.size,
            niceIndices.stream().map { obj: Int -> obj.toString() }.collect(Collectors.joining(" "))
        )
    }

    fun updateValueToCount(valueToCount: MutableMap<Long, Int>, value: Long, delta: Int) {
        valueToCount[value] = valueToCount.getOrDefault(value, 0) + delta
    }