import java.util.Scanner

fun main() {
  val sc = Scanner(System.`in`)

  val t = sc.nextInt()
  for (tc in 0 until t) {
    val s1 = sc.next()
    val pos = sc.nextLong()

    print(solve(s1, pos))
  }

  sc.close()
}

fun solve(s1: String, pos: Long): Char {
  var removeNeeded = 0
  var rest = pos
  var length = s1.length

  while (rest > length) {
    rest -= length
    length--
    removeNeeded++
  }

  val letters = mutableListOf<Char>()
  var index = 0
  while (index < s1.length) {
    if (removeNeeded > 0 && letters.isNotEmpty() && s1[index] < letters.last()) {
      letters.removeLast()
      removeNeeded--
    } else {
      letters.add(s1[index])
      index++
    }
  }

  return letters[(rest - 1).toInt()]
}