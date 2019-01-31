import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(solve(numbers));

		sc.close();
	}

	static String solve(int[] numbers) {
		Deque<Integer> row = new LinkedList<>(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
		int[] scores = new int[2];
		int index = 0;
		while (!row.isEmpty()) {
			scores[index] += (row.peekFirst() >= row.peekLast()) ? row.pollFirst() : row.pollLast();

			index = 1 - index;
		}

		return String.format("%d %d", scores[0], scores[1]);
	}
}
