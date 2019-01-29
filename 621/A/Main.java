import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

	static long solve(int[] numbers) {
		long result = 0;
		List<Integer> odds = new ArrayList<>();
		for (int number : numbers) {
			if (number % 2 == 0) {
				result += number;
			} else {
				odds.add(number);
			}
		}

		Collections.sort(odds);
		if (odds.size() % 2 != 0) {
			odds.remove(0);
		}
		result += odds.stream().mapToLong(x -> x).sum();

		return result;
	}
}
