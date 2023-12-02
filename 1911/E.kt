import java.util.PriorityQueue
import java.util.Scanner
import java.util.Collections

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    println(solve(n, k))
    sc.close()
}

fun solve(n: Int, k: Int): String {
    if (k > n || k < Integer.bitCount(n)) {
        return "NO"
    }
    val b = PriorityQueue<Int>(Collections.reverseOrder())
    var num = n
    while (num != 0) {
        val bi = Integer.highestOneBit(num)
        b.offer(bi)
        num -= bi
    }
    while (b.size != k) {
        val head = b.poll()
        b.offer(head / 2)
        b.offer(head / 2)
    }
    return String.format("YES\n%s", b.joinToString(" "))
}

