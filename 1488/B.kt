import java.util.Scanner

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    for (tc in 0 until t)
    {
      sc.nextInt()
      val k = sc.nextInt()
      val s = sc.next()
      println(solve(s, k))
    }
    sc.close()
  }
  internal fun solve(s:String, k:Int):Int {
    var outerCount = 0
    var operationTwoMax = 0
    var depth = 0
    var beginIndex = -1
    for (i in 0 until s.length)
    {
      if (s.get(i) == '(')
      {
        if (depth == 0)
        {
          beginIndex = i
        }
        ++depth
      }
      else
      {
        --depth
        if (depth == 0)
        {
          ++outerCount
          operationTwoMax += (i - beginIndex - 1) / 2
        }
      }
    }
    return outerCount + Math.min(operationTwoMax, k)
  }
