import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static long solve(int[] a, int[] b) {
		Queue<Integer> queueA = buildQueue(a);
		Queue<Integer> queueB = buildQueue(b);

		long scoreA = 0;
		long scoreB = 0;
		boolean turnAOrB = true;
		while (!queueA.isEmpty() || !queueB.isEmpty()) {
			if (turnAOrB) {
				if (queueB.isEmpty() || (!queueA.isEmpty() && queueA.peek() > queueB.peek())) {
					scoreA += queueA.poll();
				} else {
					queueB.poll();
				}
			} else {
				if (queueA.isEmpty() || (!queueB.isEmpty() && queueB.peek() > queueA.peek())) {
					scoreB += queueB.poll();
				} else {
					queueA.poll();
				}
			}

			turnAOrB = !turnAOrB;
		}

		return scoreA - scoreB;
	}

	static Queue<Integer> buildQueue(int[] values) {
		int[] sorted = Arrays.stream(values).boxed().sorted(Collections.reverseOrder()).mapToInt(x -> x).toArray();

		Queue<Integer> queue = new LinkedList<>();
		for (int value : sorted) {
			queue.offer(value);
		}
		return queue;
	}
}
