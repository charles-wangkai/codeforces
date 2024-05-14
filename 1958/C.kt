import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val n = sc.nextInt()
    val k = sc.nextLong()
    println(solve(n, k))
  }
}

fun solve(n: Int, k: Long): Int {
  return n - k.countTrailingZeroBits()
}
