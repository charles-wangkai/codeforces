import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)

  val t = sc.nextInt()
  for (tc in 0 until t) {
    val n = sc.nextInt()
    val a = IntArray(n) { sc.nextInt() }

    println(solve(a))
  }

  sc.close()
}

fun solve(a: IntArray): Int {
  val n = a.size

  if (a.distinct().count() == 1) return 0

  var leftLength = 1
  while (leftLength < n && a[leftLength] == a[leftLength - 1]) {
    leftLength++
  }

  var rightLength = 1
  while (rightLength < n && a[n - rightLength - 1] == a[n - rightLength]) {
    rightLength++
  }

  return n - (if (a[0] == a[n - 1]) leftLength + rightLength else maxOf(leftLength, rightLength))
}