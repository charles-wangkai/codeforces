import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val n = sc.nextInt()
    val a = IntArray(n) { sc.nextInt() }
    println(solve(a))
  }
}

fun solve(a: IntArray): Long {
  var result = 0L
  var beginIndex = 0

  for (i in 0..a.size) {
    if (i == a.size || a[i] == 0) {
      var cost = 2 * a.sliceArray(beginIndex until i).sumOf { it.toLong() }
      if ((i - beginIndex) % 2 == 1) {
        cost -= a.slice(beginIndex until i).filterIndexed { index, _ -> index % 2 == 0 }.maxOrNull() ?: 0
      }
      result += cost
      beginIndex = i + 1
    }
  }

  return result
}
