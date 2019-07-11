import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, long k) {
		if (k >= a.length - 1) {
			return Arrays.stream(a).max().getAsInt();
		}

		int winner = a[0];
		int winCount = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < a.length; i++) {
			queue.offer(a[i]);
		}

		while (true) {
			int challenger = queue.poll();

			if (winner > challenger) {
				queue.offer(challenger);

				winCount++;
			} else {
				queue.offer(winner);

				winner = challenger;
				winCount = 1;
			}

			if (winCount == k) {
				return winner;
			}
		}
	}
}
