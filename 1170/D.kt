import java.util.ArrayList
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import java.util.Scanner
import java.util.stream.Collectors

fun main(args: Array<String>?) {
	val sc = Scanner(System.`in`)
	val m = sc.nextInt()
	val b = IntArray(m)
	for (i in b.indices) {
		b[i] = sc.nextInt()
	}
	System.out.print(solve(b))
	sc.close()
}

private fun solve(b: IntArray?): String? {
	val n = Arrays.stream(b).filter({ x -> x == -1 }).count().toInt()
	@SuppressWarnings("unchecked")
	val sequences = arrayOfNulls<ArrayList<Int>>(n)
	for (i in sequences.indices) {
		sequences[i] = ArrayList()
	}
	val queue = LinkedList<Int>()
	for (i in 0 until n) {
		queue.offer(i)
	}
	for (bi in b!!) {
		val index = queue.poll()
		if (bi != -1) {
			sequences[index]!!.add(bi)
			queue.offer(index)
		}
	}
	return String.format("%d\n%s", n,
			Arrays.stream(sequences)
					.map({ sequence ->
						String.format("%d %s", sequence!!.size,
								sequence.stream().map { it.toString() }.collect(Collectors.joining(" ")))
					})
					.collect(Collectors.joining("\n")))
}
