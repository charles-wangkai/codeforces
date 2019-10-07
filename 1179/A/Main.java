import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		long[] m = new long[q];
		for (int i = 0; i < m.length; i++) {
			m[i] = sc.nextLong();
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static String solve(int[] a, long[] m) {
		Deque<Integer> deque = new LinkedList<>();
		for (int ai : a) {
			deque.offerLast(ai);
		}

		int max = Arrays.stream(a).max().getAsInt();
		List<Integer> As = new ArrayList<>();
		List<Integer> Bs = new ArrayList<>();
		while (true) {
			int A = deque.pollFirst();
			int B = deque.pollFirst();
			As.add(A);
			Bs.add(B);

			if (A == max) {
				deque.offerFirst(B);
				deque.offerFirst(A);

				break;
			}

			int lower = Math.min(A, B);
			int upper = Math.max(A, B);
			deque.offerFirst(upper);
			deque.offerLast(lower);
		}

		List<Integer> remains = deque.stream().skip(1).collect(Collectors.toList());

		String[] result = new String[m.length];
		for (int i = 0; i < result.length; i++) {
			int A;
			int B;
			if (m[i] <= As.size()) {
				A = As.get((int) m[i] - 1);
				B = Bs.get((int) m[i] - 1);
			} else {
				A = max;
				B = remains.get((int) ((m[i] - As.size()) % remains.size()));
			}

			result[i] = String.format("%d %d", A, B);
		}

		return String.join("\n", result);
	}
}
