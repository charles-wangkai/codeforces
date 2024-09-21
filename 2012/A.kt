import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)

  val t = sc.nextInt()
  for (tc in 0 until t) {
    val x = sc.nextInt()
    val y = sc.nextInt()

    println(solve(x, y))
  }

  sc.close()  

}

fun solve(x: Int, y: Int): String {
  return "${Math.min(x, y)} ${Math.max(x, y)}"
}