import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val n = sc.nextInt()
    val a = LongArray(n) { sc.nextLong() }
    println(solve(a))
  }
}

fun solve(a: LongArray): Long {
  a.sort()
  return a.indices.map { i -> (a.size - i) * a[i] }.maxOf { it }
}
