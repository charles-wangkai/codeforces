import java.util.Scanner

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val k = sc.nextInt()
	for (tc in 0 until k) {
		val s = sc.next()
		val t = sc.next()
		System.out.println(if (solve(s, t)) "YES" else "NO")
	}
	sc.close()
}

internal fun solve(s: String?, t: String?): Boolean {
	var index = 0
	for (target in t!!.toCharArray()) {
		if (index == s!!.length) {
			return false
		}
		if (s[index] == target) {
			index++
		} else {
			if (target == '-') {
				return false
			}
			if (index + 1 == s.length || s[index + 1] == '+') {
				return false
			}
			index += 2
		}
	}
	return index == s!!.length
}
