import java.util.LinkedList;
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

		List<Integer> result = solve(a);
		System.out.println(result.size());
		System.out.println(String.join(" ", result.stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(int[] a) {
		List<Integer> result = new LinkedList<>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (!result.contains(a[i])) {
				result.add(0, a[i]);
			}
		}
		return result;
	}
}
