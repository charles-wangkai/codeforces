import java.util.Scanner

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val a = IntArray(n)
	for (i in a.indices) {
		a[i] = sc.nextInt()
	}
	System.out.println(solve(a))
	sc.close()
}

private fun solve(a: IntArray?): Int {
	var max1 = Integer.MIN_VALUE
	var max2 = Integer.MIN_VALUE
	var result = 0
	for (ai in a!!) {
		if (ai >= max1) {
			max2 = max1
			max1 = ai
		} else if (ai >= max2) {
			max2 = ai
		} else {
			result++
		}
	}
	return result
}
