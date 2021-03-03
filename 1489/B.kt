import java.util.Scanner

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val q = sc.nextInt()
    for (tc in 0 until q)
    {
      val n = sc.nextLong()
      val a = sc.nextInt()
      val b = sc.nextInt()
      println(solve(n, a, b))
    }
    sc.close()
  }
  internal fun solve(n:Long, a:Int, b:Int):Long {
    return (n / 2 * Math.min(2 * a, b)) + (n % 2 * a)
  }