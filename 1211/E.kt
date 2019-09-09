import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.Scanner

fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  val a = IntArray(n)
  for (i in a.indices) {
    a[i] = sc.nextInt()
  }
  println(solve(a))
  sc.close()
}
internal fun solve(a: IntArray): String {
  val valueToIndices = HashMap<Int, MutableList<Int>>()
  for (i in a.indices) {
    if (!valueToIndices.containsKey(a[i])) {
      valueToIndices.put(a[i], ArrayList<Int>())
    }
    valueToIndices.get(a[i])!!.add(i)
  }
  val permutationSize = computePermutationSize(a, valueToIndices)
  val result = StringBuilder()
  for (i in a.indices) {
    result.append('B')
  }
  for (i in 1..permutationSize) {
    val indices = valueToIndices.get(i)
    result.setCharAt(indices!!.get(0), 'R')
    result.setCharAt(indices.get(1), 'G')
  }
  return result.toString()
}
internal fun computePermutationSize(a: IntArray, valueToIndices: Map<Int, List<Int>>): Int {
  var lower = 1
  var upper = 0
  while (valueToIndices.getOrDefault(upper + 1, ArrayList<Int>()).size == 2) {
    upper++
  }
  var result = 0
  while (lower <= upper) {
    val middle = (lower + upper) / 2
    if (check(a, middle)) {
      result = middle
      lower = middle + 1
    } else {
      upper = middle - 1
    }
  }
  return result
}
internal fun check(a: IntArray, permutationSize: Int): Boolean {
  val queue = LinkedList<Int>()
  val set = HashSet<Int>()
  for (ai in a) {
    if (ai > permutationSize) {
      continue
    }
    if (!queue.isEmpty() && queue.peek() == ai) {
      queue.poll()
      set.remove(ai)
    } else if (set.contains(ai)) {
      return false
    } else {
      queue.offer(ai)
      set.add(ai)
    }
  }
  return true
}
