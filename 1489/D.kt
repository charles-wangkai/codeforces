import java.util.Arrays
import java.util.Comparator
import java.util.Scanner
import java.util.stream.IntStream

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val strings = arrayOfNulls<String>(n)
    for (i in strings.indices)
    {
      strings[i] = sc.next()
    }
    println(solve(strings))
    sc.close()
  }
  internal fun solve(strings:Array<String?>):String {
    Arrays.sort<String>(strings, compareBy({ it!!.length }))
    if (IntRange(0, strings.size - 2).all({ i-> strings[i + 1]!!.contains(strings[i]!!) }))
    {
      return String.format("YES\n%s", strings.joinToString("\n"))
    }
    else
    {
      return "NO"
    }
  }
