import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int LIMIT = 10000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(solve(n, m));

		sc.close();
	}

	static int solve(int n, int m) {
		int[] distances = new int[LIMIT * 2 + 1];
		Arrays.fill(distances, -1);

		Queue<Integer> queue = new LinkedList<>();
		distances[n] = 0;
		queue.offer(n);

		while (true) {
			int head = queue.poll();

			if (head == m) {
				return distances[head];
			}

			if (head * 2 < distances.length && distances[head * 2] < 0) {
				distances[head * 2] = distances[head] + 1;
				queue.offer(head * 2);
			}

			if (head >= 2 && distances[head - 1] < 0) {
				distances[head - 1] = distances[head] + 1;
				queue.offer(head - 1);
			}
		}
	}
}
