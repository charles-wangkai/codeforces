import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val n = sc.nextInt()
  val r = IntArray(n)
  for (i in r.indices) {
    r[i] = sc.nextInt()
  }
  println(solve(r))
  sc.close()
}
internal fun solve(r: IntArray): String {
  val complexities = Arrays.stream(r).boxed().distinct().sorted().mapToInt({ x -> x }).toArray()
  if (complexities.size < 3) {
    return "-1 -1 -1"
  }
  return String.format("%d %d %d", findSequence(r, complexities[0]), findSequence(r, complexities[1]),
                       findSequence(r, complexities[2]))
}
internal fun findSequence(r: IntArray, target: Int): Int {
  return IntRange(0, r.size).find({ i -> r[i] == target })!! + 1
}
