import java.util.Arrays
import java.util.Scanner

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val n = sc.nextInt()
	val m = sc.nextInt()
	val k = sc.nextInt()
	val a = IntArray(n)
	for (i in a.indices) {
		a[i] = sc.nextInt()
	}
	System.out.println(solve(a, m, k))
	sc.close()
}

private fun solve(_a: IntArray?, m: Int, k: Int): Long {
	val a = Arrays.stream(_a).boxed().sorted().mapToInt({ x -> x }).toArray()
	val prefixSums = buildPrefixSums(a)
	var result = Long.MAX_VALUE
	for (beginIndex in 0..a!!.size - m) {
		val endIndex = beginIndex + m - 1
		val rightMostIndex = findRightMostIndex(a, k, prefixSums, beginIndex, endIndex)
		val centerIndex = (beginIndex + endIndex) / 2
		val leftIndex: Int
		val centerValue: Int
		if (rightMostIndex < centerIndex) {
			leftIndex = rightMostIndex
			val leftCount = leftIndex - beginIndex + 1
			centerValue = (a[rightMostIndex] + ((((k - ((leftCount.toLong() * a[rightMostIndex] - computeRangeSum(prefixSums, beginIndex, rightMostIndex))))) / leftCount)).toInt())
		} else {
			leftIndex = centerIndex
			centerValue = a[centerIndex]
		}
		val minuteNum = computeMinuteNum(prefixSums, beginIndex, endIndex, leftIndex, centerValue)
		result = Math.min(result, minuteNum)
	}
	return result
}

private fun buildPrefixSums(a: IntArray?): LongArray? {
	val prefixSums = LongArray(a!!.size)
	var prefixSum: Long = 0
	for (i in prefixSums.indices) {
		prefixSum += a[i].toLong()
		prefixSums[i] = prefixSum
	}
	return prefixSums
}

private fun findRightMostIndex(a: IntArray?, k: Int, prefixSums: LongArray?, beginIndex: Int, endIndex: Int): Int {
	var result = -1
	var lowerIndex = beginIndex
	var upperIndex = endIndex
	while (lowerIndex <= upperIndex) {
		val middleIndex = (lowerIndex + upperIndex) / 2
		if ((((middleIndex - beginIndex + 1L) * a!![middleIndex] - computeRangeSum(prefixSums, beginIndex, middleIndex)) <= k)) {
			result = middleIndex
			lowerIndex = middleIndex + 1
		} else {
			upperIndex = middleIndex - 1
		}
	}
	return result
}

private fun computeMinuteNum(prefixSums: LongArray?, beginIndex: Int, endIndex: Int, leftIndex: Int, centerValue: Int): Long {
	val leftCount = leftIndex - beginIndex + 1
	val rightCount = endIndex - leftIndex
	return ((leftCount.toLong() * centerValue - computeRangeSum(prefixSums, beginIndex, leftIndex)) + (computeRangeSum(prefixSums, leftIndex + 1, endIndex) - rightCount.toLong() * centerValue))
}

private fun computeRangeSum(prefixSums: LongArray?, beginIndex: Int, endIndex: Int): Long {
	return prefixSums!![endIndex] - (if (beginIndex == 0) 0 else prefixSums[beginIndex - 1])
}
