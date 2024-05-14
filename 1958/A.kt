import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)
  val t = sc.nextInt()

  for (tc in 0 until t) {
    val n = sc.nextInt()
    println(solve(n))
  }
}

fun solve(n: Int): Int {
  var i = 0
  while (true) {
    if (check(n - i)) {
      return i
    }
    i++
  }
}

fun check(x: Int): Boolean {
  for (i in 0..x step 3) {
    if ((x - i) % 5 == 0) {
      return true
    }
  }
  return false
}
