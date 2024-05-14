import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val n = sc.nextInt()
    val k = sc.nextInt()
    println(solve(n, k))
  }
}

fun solve(n: Int, k: Int): String {
  val result = mutableListOf(n, n - 1)
  var value = n - 2
  for (i in 0 until k - 1) {
    val count = result.lastIndex
    for (j in 0 until count) {
      if (value == 0) {
        return "-1"
      }
      result.add(j * 2 + 1, value--)
    }
  }
  for (i in value downTo 1) {
    result.add(0, i)
  }
  return result.joinToString(" ")
}
