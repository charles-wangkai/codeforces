import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(n, l, r));

		sc.close();
	}

	static String solve(int n, int l, int r) {
		return String.format("%d %d", computeMinSum(n, l), computeMaxSum(n, r));
	}

	static int computeMinSum(int n, int l) {
		List<Integer> elements = new ArrayList<>();
		for (int i = 0; i < l; i++) {
			elements.add(1 << i);
		}

		return elements.stream().mapToInt(x -> x).sum() + elements.get(0) * (n - elements.size());
	}

	static int computeMaxSum(int n, int r) {
		List<Integer> elements = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			elements.add(1 << i);
		}

		return elements.stream().mapToInt(x -> x).sum() + elements.get(elements.size() - 1) * (n - elements.size());
	}
}
