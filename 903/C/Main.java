import java.util.HashMap;
import java.util.Map;
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
		Map<Integer, Integer> sideToCount = new HashMap<>();
		for (int side : a) {
			sideToCount.put(side, sideToCount.getOrDefault(side, 0) + 1);
		}

		return sideToCount.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
