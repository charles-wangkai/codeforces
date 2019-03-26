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
		System.out.print(solve(a));

		sc.close();
	}

	@SuppressWarnings("unchecked")
	static String solve(int[] a) {
		List<Integer> set1 = new ArrayList<>();
		List<Integer> set2 = new ArrayList<>();
		List<Integer> set3 = new ArrayList<>();

		for (int number : a) {
			if (number < 0 && set1.isEmpty()) {
				set1.add(number);
			} else if (number == 0 && set3.isEmpty()) {
				set3.add(number);
			} else {
				set2.add(number);
			}
		}

		int negCount2 = (int) set2.stream().filter(x -> x < 0).count();
		if (negCount2 % 2 != 0) {
			for (int i = 0;; i++) {
				if (set2.get(i) < 0) {
					set3.add(set2.remove(i));

					break;
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (List<Integer> set : new List[] { set1, set2, set3 }) {
			result.append(set.size());
			for (int number : set) {
				result.append(" ").append(number);
			}
			result.append("\n");
		}
		return result.toString();
	}
}
