    import java.util.Scanner
     fun main(args:Array<String>) {
        val sc = Scanner(System.`in`)
        val t = sc.nextInt()
        for (tc in 0 until t)
        {
          val n = sc.nextInt()
          println(solve(n))
        }
        sc.close()
      }
      internal fun solve(n:Int):String {
        if (n <= 999)
        {
          return String.format("%d", n)
        }
        else if (n <= 999499)
        {
          return String.format("%dK", (n + 500) / 1000)
        }
        else
        {
          return String.format("%dM", (n + 500000) / 1000000)
        }
      }