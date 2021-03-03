import java.util.Scanner

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    sc.nextInt()
    val fileName = sc.next()
    println(solve(fileName))
    sc.close()
  }
  internal fun solve(fileName:String):Int {
    var result = 0
    var count = 0
    for (i in 0..fileName.length)
    {
      if (i >= 1 && i < fileName.length && fileName.get(i) == fileName.get(i - 1))
      {
        ++count
      }
      else
      {
        if (i >= 1 && fileName.get(i - 1) == 'x')
        {
          result += Math.max(0, count - 2)
        }
        count = 1
      }
    }
    return result
  }
