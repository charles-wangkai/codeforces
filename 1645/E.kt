import java.util.*
import java.util.stream.Collectors

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    println(solve(n, k))
    sc.close()
}

fun solve(n: Int, k: Int): String {
    var n = n
    if (k > n || k < Integer.bitCount(n)) {
        return "NO"
    }
    val b = PriorityQueue(Collections.reverseOrder<Int>())
    while (n != 0) {
        val bi = Integer.highestOneBit(n)
        b.offer(bi)
        n -= bi
    }
    while (b.size != k) {
        val head = b.poll()
        b.offer(head / 2)
        b.offer(head / 2)
    }
    return String.format(
        "YES\n%s", b.stream().map { obj: Int? -> java.lang.String.valueOf(obj) }.collect(Collectors.joining(" "))
    )
}