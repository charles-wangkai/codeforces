import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  val a = IntArray(n)
  for (i in a.indices) {
    a[i] = sc.nextInt()
  }
  println(solve(a))
  sc.close()
}
internal fun solve(a: IntArray): Long {
  val max = Arrays.stream(a).max().getAsInt()
  var i = a.size - 1
  while (true) {
    if (a[i] == max) {
      return (max - 1L) * a.size + (i + 1)
    }
    i--
  }
}
