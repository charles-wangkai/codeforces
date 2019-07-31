import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] SEQUENCE = { 4, 8, 15, 16, 23, 42 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		@SuppressWarnings("unchecked")
		Queue<Integer>[] indexQueues = new Queue[SEQUENCE.length];
		for (int i = 0; i < indexQueues.length; i++) {
			indexQueues[i] = new LinkedList<>();
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0;; j++) {
				if (SEQUENCE[j] == a[i]) {
					indexQueues[j].offer(i);

					break;
				}
			}
		}

		int subsequenceNum = 0;
		while (true) {
			boolean found = true;
			int minIndex = 0;

			for (int i = 0; i < SEQUENCE.length; i++) {
				while (!indexQueues[i].isEmpty() && indexQueues[i].peek() < minIndex) {
					indexQueues[i].poll();
				}

				if (indexQueues[i].isEmpty()) {
					found = false;
					break;
				}

				minIndex = indexQueues[i].poll() + 1;
			}

			if (!found) {
				break;
			}

			subsequenceNum++;
		}

		return a.length - subsequenceNum * SEQUENCE.length;
	}
}
