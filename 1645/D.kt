import java.util.*
import java.util.stream.Collectors

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

fun solve(a: IntArray): String {
    Arrays.sort(a)
    val increasing: MutableList<Int?> = ArrayList()
    val decreasing: MutableList<Int?> = ArrayList()
    for (number in a) {
        if (increasing.isEmpty() || increasing[increasing.size - 1] != number) {
            increasing.add(number)
        } else if (decreasing.isEmpty() || decreasing[decreasing.size - 1] != number) {
            decreasing.add(number)
        } else {
            return "NO"
        }
    }
    Collections.reverse(decreasing)
    return String.format("YES\n%s\n%s", output(increasing), output(decreasing))
}

fun output(sequence: List<Int?>): String {
    return String.format(
        "%d\n%s",
        sequence.size,
        sequence.stream().map { obj: Int? -> java.lang.String.valueOf(obj) }.collect(Collectors.joining(" "))
    )
}