import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a2 % 10, a1 % 10));
		for (int ai : a) {
			pq.offer(ai);
		}

		int result = 0;
		while (!pq.isEmpty() && k != 0) {
			int head = pq.poll();

			if (head == 100) {
				result += 10;
			} else {
				int unit = Math.min(k, 10 - head % 10);

				pq.offer(head + unit);
				k -= unit;
			}
		}

		while (!pq.isEmpty()) {
			result += pq.poll() / 10;
		}

		return result;
	}
}
