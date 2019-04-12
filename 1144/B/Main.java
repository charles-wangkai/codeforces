import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<Integer> evens = new ArrayList<>();
		List<Integer> odds = new ArrayList<>();

		for (int ai : a) {
			if (ai % 2 == 0) {
				evens.add(ai);
			} else {
				odds.add(ai);
			}
		}

		int commonSize = Math.min(evens.size(), odds.size());
		return computeMinSum(evens, evens.size() - commonSize - 1) + computeMinSum(odds, odds.size() - commonSize - 1);
	}

	static int computeMinSum(List<Integer> numbers, int limitSize) {
		return numbers.stream().mapToInt(x -> x).sorted().limit(Math.max(0, limitSize)).sum();
	}
}
