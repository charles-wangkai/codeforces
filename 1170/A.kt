import java.util.Scanner

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val q = sc.nextInt()
	for (tc in 0 until q) {
		val x = sc.nextInt()
		val y = sc.nextInt()
		System.out.println(solve(x, y))
	}
	sc.close()
}

internal fun solve(x: Int, y: Int): String? {
	val a = Math.min(x, y) - 1
	val b = x - a
	val c = y - a
	return String.format("%d %d %d", a, b, c)
}
