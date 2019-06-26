import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(Arrays.stream(solve(a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int[] a) {
		PriorityQueue<Integer> evens = new PriorityQueue<>();
		PriorityQueue<Integer> odds = new PriorityQueue<>();

		for (int ai : a) {
			if (ai % 2 == 0) {
				evens.offer(ai);
			} else {
				odds.offer(ai);
			}
		}

		if (evens.isEmpty() || odds.isEmpty()) {
			return a;
		}

		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++) {
			if (odds.isEmpty() || (!evens.isEmpty() && evens.peek() < odds.peek())) {
				result[i] = evens.poll();
			} else {
				result[i] = odds.poll();
			}
		}
		return result;
	}
}
