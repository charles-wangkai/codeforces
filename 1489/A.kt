import java.util.LinkedList
import java.util.Scanner
import java.util.stream.Collectors

  fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in a.indices)
    {
      a[i] = sc.nextInt()
    }
    println(solve(a))
    sc.close()
  }
  internal fun solve(a:IntArray):String {
    val uniques = LinkedList<Int>()
    for (i in a.indices.reversed())
    {
      if (!uniques.contains(a[i]))
      {
        uniques.add(0, a[i])
      }
    }
    return String.format(
      "%d\n%s",
      uniques.size, uniques.stream().map<String>({ (it).toString() }).collect(Collectors.joining(" ")))
  }