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

	static String solve(int[] a) {
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		for (int ai : a) {
			if (ai > 0) {
				first.add(ai);
			} else {
				second.add(-ai);
			}
		}

		long diff = first.stream().mapToLong(x -> x).sum() - second.stream().mapToLong(x -> x).sum();
		if (diff < 0) {
			return "second";
		} else if (diff > 0) {
			return "first";
		}

		int index = 0;
		while (index < first.size() && index < second.size() && first.get(index).equals(second.get(index))) {
			index++;
		}

		if (index < first.size()) {
			if (index < second.size()) {
				if (first.get(index) < second.get(index)) {
					return "second";
				} else {
					return "first";
				}
			} else {
				return "second";
			}
		} else {
			if (index < second.size()) {
				return "first";
			} else {
				if (a[a.length - 1] < 0) {
					return "second";
				} else {
					return "first";
				}
			}
		}
	}
}
