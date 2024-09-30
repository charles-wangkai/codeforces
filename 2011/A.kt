import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)

  val t = sc.nextInt()
  for (tc in 0 until t) {
    val n = sc.nextInt()
    val d = IntArray(n) { sc.nextInt() }

    println(solve(d))
  }

  sc.close()
}

fun solve(d: IntArray): String {
  val maxBeforeLast = d.slice(0 until d.lastIndex).maxOrNull() ?: 0 // Get max excluding last element

  return if (d.last() == maxBeforeLast + 1) {
    (d.last() - 1).toString()
  } else {
    "Ambiguous"
  }
}