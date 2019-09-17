import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(n, a));

		sc.close();
	}

	static String solve(int n, int[] a) {
		int maxEarn = computeEarn(n, a, Comparator.reverseOrder());
		int minEarn = computeEarn(n, a, Comparator.naturalOrder());

		return String.format("%d %d", maxEarn, minEarn);
	}

	static int computeEarn(int n, int[] a, Comparator<Integer> comparator) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comparator);
		for (int ai : a) {
			pq.offer(ai);
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			int head = pq.poll();
			result += head;

			if (head != 1) {
				pq.offer(head - 1);
			}
		}

		return result;
	}
}
