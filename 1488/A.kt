import java.util.Scanner

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t)
    {
      val x = sc.nextInt()
      val y = sc.nextInt()
      println(solve(x, y))
    }
    sc.close()
  }
  internal fun solve(x:Int, y:Int):Int {
    return y % x + (y / x).toString().chars().map({ ch-> ch - '0'.toInt() }).sum()
  }
