import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		if (k > n || k < Integer.bitCount(n)) {
			return "NO";
		}

		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
		while (n != 0) {
			int bi = Integer.highestOneBit(n);

			b.offer(bi);
			n -= bi;
		}

		while (b.size() != k) {
			int head = b.poll();

			b.offer(head / 2);
			b.offer(head / 2);
		}

		return String.format("YES\n%s", b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}
