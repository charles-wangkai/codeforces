import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val k = sc.nextInt()
    val m = sc.nextInt()
    println(solve(k, m))
  }
}

fun solve(k: Int, m: Int): Int {
  return maxOf(0, 2 * k - m % (3 * k))
}
