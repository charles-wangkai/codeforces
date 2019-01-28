import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] h = new int[n];
		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
			m[i] = sc.nextInt();
		}
		System.out.println(solve(h, m));

		sc.close();
	}

	static int solve(int[] h, int[] m) {
		Map<Integer, Integer> totalMinuteToCount = new HashMap<>();
		for (int i = 0; i < h.length; i++) {
			int totalMinute = h[i] * 60 + m[i];
			totalMinuteToCount.put(totalMinute, totalMinuteToCount.getOrDefault(totalMinute, 0) + 1);
		}
		return totalMinuteToCount.values().stream().mapToInt(x -> x).max().getAsInt();
	}
}
