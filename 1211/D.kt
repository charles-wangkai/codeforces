import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.HashSet
import java.util.Scanner

fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  val a = sc.nextInt()
  val b = sc.nextInt()
  val k = sc.nextInt()
  val r = IntArray(n)
  for (i in r.indices) {
    r[i] = sc.nextInt()
  }
  println(solve(r, a, b, k))
  sc.close()
}
internal fun solve(r: IntArray, a: Int, b: Int, k: Int): Int {
  val valueToCount = HashMap<Int, Int>()
  for (value in r) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1)
  }
  val values = ArrayList<Int>(valueToCount.keys)
  Collections.sort<Int>(values)
  val processed = HashSet<Int>()
  var result = 0
  for (value in values) {
    if (processed.contains(value)) {
      continue
    }
    val counts = ArrayList<Int>()
    var i = value
    while (valueToCount.containsKey(i)) {
      counts.add(valueToCount.get(i)!!)
      processed.add(i)
      i *= k
    }
    result += computeTeamNum(a, b, counts)
  }
  return result
}
internal fun computeTeamNum(a: Int, b: Int, counts: MutableList<Int>): Int {
  if (a < b) {
    Collections.reverse(counts)
    return computeTeamNum(b, a, counts)
  }
  var result = 0
  for (i in 0 until counts.size - 1) {
    val teamNum = Math.min(counts.get(i) / a, counts.get(i + 1) / b)
    result += teamNum
    counts.set(i + 1, counts.get(i + 1) - b * teamNum)
  }
  return result
}

