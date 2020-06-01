import java.util.Scanner
  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t)
    {
      val n = sc.nextInt()
      val k = sc.nextInt()
      println(solve(n, k))
    }
    sc.close()
  }
  internal fun solve(n:Int, k:Int):String {
    val n1 = n / (1 + k + k * k + k * k * k)
    val n2 = n1 * k
    val n3 = n2 * k
    val n4 = n3 * k
    return String.format("%d %d %d %d", n1, n2, n3, n4)
  }