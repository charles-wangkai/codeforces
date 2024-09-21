import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)

  val t = sc.nextInt()
  for (tc in 0 until t) {
    sc.nextInt()
    val s = sc.next()

    println(if (solve(s)) "Yes" else "No")
  }

  sc.close()
}

fun solve(s: String): Boolean {
  val size = Math.sqrt(s.length.toDouble()).toInt()
  return size * size == s.length && s.indices.all { i ->
    val r = i / size
    val c = i % size
    s[i] == if (r == 0 || r == size - 1 || c == 0 || c == size - 1) '1' else '0'
  }
}