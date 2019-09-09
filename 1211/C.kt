import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  val k = sc.nextInt()
  val days = arrayOfNulls<Day>(n)
  for (i in days.indices) {
    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = sc.nextInt()
    days[i] = Day(a, b, c)
  }
  println(solve(days, k))
  sc.close()
}
internal fun solve(days: Array<Day?>, _k: Int): Long {
  var k = _k
  if ((k < Arrays.stream<Day>(days).mapToLong({ day -> day.a.toLong() }).sum() || k > Arrays.stream<Day>(days).mapToLong({ day -> day.b.toLong() }).sum())) {
    return -1
  }
  Arrays.sort<Day>(days, { day1, day2 -> Integer.compare(day1.c, day2.c) })
  val suffixMinSums = LongArray(days.size + 1)
  var suffixMinSum: Long = 0
  for (i in suffixMinSums.size - 2 downTo 0) {
    suffixMinSum += days[i]!!.a.toLong()
    suffixMinSums[i] = suffixMinSum
  }
  var result: Long = 0
  for (i in days.indices) {
    val count = Math.min(days[i]!!.b.toLong(), Math.max(0, k - suffixMinSums[i + 1])).toInt()
    result += count.toLong() * days[i]!!.c
    k -= count
  }
  return result
}

internal class Day(a: Int, b: Int, c: Int) {
  var a: Int = 0
  var b: Int = 0
  var c: Int = 0
  init {
    this.a = a
    this.b = b
    this.c = c
  }
}

