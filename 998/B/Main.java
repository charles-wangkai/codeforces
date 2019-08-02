import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int B = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, B));

		sc.close();
	}

	static int solve(int[] a, int B) {
		List<Integer> costs = new ArrayList<>();

		int depth = 0;
		for (int i = 0; i < a.length - 1; i++) {
			depth += (a[i] % 2 == 0) ? 1 : -1;

			if (depth == 0) {
				costs.add(Math.abs(a[i] - a[i + 1]));
			}
		}

		Collections.sort(costs);

		int result = 0;
		int totalCost = 0;
		for (int cost : costs) {
			if (totalCost + cost > B) {
				break;
			}

			result++;
			totalCost += cost;
		}
		return result;
	}
}
