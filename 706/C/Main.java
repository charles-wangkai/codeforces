import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		String[] strings = new String[n];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = sc.next();
		}
		System.out.println(solve(c, strings));

		sc.close();
	}

	static long solve(int[] c, String[] strings) {
		String[] reversedStrings = Arrays.stream(strings).map(s -> new StringBuilder(s).reverse().toString())
				.toArray(String[]::new);

		long originalCost = 0;
		long reversedCost = c[0];
		for (int i = 1; i < c.length; i++) {
			long nextOriginalCost = computeCost(strings[i], strings[i - 1], reversedStrings[i - 1], originalCost,
					reversedCost, 0);
			long nextReversedCost = computeCost(reversedStrings[i], strings[i - 1], reversedStrings[i - 1],
					originalCost, reversedCost, c[i]);

			originalCost = nextOriginalCost;
			reversedCost = nextReversedCost;
		}

		long minCost = Math.min(originalCost, reversedCost);
		return (minCost == Long.MAX_VALUE) ? -1 : minCost;
	}

	static long computeCost(String current, String prevString, String prevReversedString, long originalCost,
			long reversedCost, int deltaCost) {
		long cost = Long.MAX_VALUE;

		if (current.compareTo(prevString) >= 0) {
			cost = Math.min(cost, originalCost);
		}
		if (current.compareTo(prevReversedString) >= 0) {
			cost = Math.min(cost, reversedCost);
		}

		if (cost == Long.MAX_VALUE) {
			return Long.MAX_VALUE;
		}

		return cost + deltaCost;
	}
}
