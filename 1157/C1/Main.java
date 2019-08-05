import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.print(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		Deque<Integer> sequence = new LinkedList<>();
		for (int ai : a) {
			sequence.offer(ai);
		}

		StringBuilder moves = new StringBuilder();
		int prev = -1;
		while (!sequence.isEmpty() && (sequence.peekFirst() > prev || sequence.peekLast() > prev)) {
			if (sequence.peekFirst() > prev
					&& (sequence.peekFirst() < sequence.peekLast() || sequence.peekLast() < prev)) {
				prev = sequence.pollFirst();
				moves.append('L');
			} else {
				prev = sequence.pollLast();
				moves.append('R');
			}
		}

		return String.format("%d\n%s", moves.length(), moves.toString());
	}
}
