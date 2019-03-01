import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
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
		SortedMap<Integer, Integer> numberToCount = new TreeMap<>();
		for (int number : a) {
			increase(numberToCount, number);
		}

		return IntStream.of(Arrays.stream(a).min().getAsInt(), Arrays.stream(a).max().getAsInt())
				.map(number -> getInstabilityAfterRemove(numberToCount, number)).min().getAsInt();
	}

	static int getInstabilityAfterRemove(SortedMap<Integer, Integer> numberToCount, int number) {
		decrease(numberToCount, number);
		int result = numberToCount.lastKey() - numberToCount.firstKey();
		increase(numberToCount, number);

		return result;
	}

	static void increase(SortedMap<Integer, Integer> numberToCount, int number) {
		numberToCount.put(number, numberToCount.getOrDefault(number, 0) + 1);
	}

	static void decrease(SortedMap<Integer, Integer> numberToCount, int number) {
		numberToCount.put(number, numberToCount.get(number) - 1);

		if (numberToCount.get(number) == 0) {
			numberToCount.remove(number);
		}
	}
}
