import java.util.ArrayList
import java.util.Scanner

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val m = sc.nextInt()
	val a = IntArray(n)
	for (i in a.indices) {
		a[i] = sc.nextInt()
	}
	val prefixSums = IntArray(a.size)
	var prefixSum = 0
	for (i in prefixSums.indices) {
		prefixSum += a[i]
		prefixSums[i] = prefixSum
	}
	val q = sc.nextInt()
	val output = StringBuilder()
	for (tc in 0 until q) {
		val ck = sc.nextInt()
		val w = IntArray(ck)
		for (i in w.indices) {
			w[i] = sc.nextInt()
		}
		output.append(if (solve(prefixSums, m, w)) "YES" else "NO").append("\n")
	}
	System.out.print(output)
	sc.close()
}

private fun solve(prefixSums: IntArray?, m: Int, w: IntArray?): Boolean {
	val ws = ArrayList<Int>()
	ws.add(0)
	for (wi in w!!) {
		ws.add(wi)
	}
	ws.add(m + 1)
	val diffs = IntArray(ws.size - 1)
	for (i in diffs.indices) {
		diffs[i] = ws.get(i + 1) - ws.get(i) - 1
	}
	var index = -1
	for (diff in diffs) {
		val target = (if ((index == -1)) 0 else prefixSums!![index]) + diff
		index = findIndex(prefixSums, target)
	}
	return index == prefixSums!!.size - 1
}

private fun findIndex(prefixSums: IntArray?, target: Int): Int {
	var result = -1
	var lower = 0
	var upper = prefixSums!!.size - 1
	while (lower <= upper) {
		val middle = (lower + upper) / 2
		if (prefixSums[middle] <= target) {
			result = middle
			lower = middle + 1
		} else {
			upper = middle - 1
		}
	}
	return result
}
