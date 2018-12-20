import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] h = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
			a[i] = sc.nextInt();
		}
		System.out.println(solve(h, a));

		sc.close();
	}

	static int solve(int[] h, int[] a) {
		Map<Integer, Integer> colorToCountH = buildColorToCount(h);
		Map<Integer, Integer> colorToCountA = buildColorToCount(a);

		return colorToCountH.keySet().stream()
				.mapToInt(colorH -> colorToCountH.get(colorH) * colorToCountA.getOrDefault(colorH, 0)).sum();
	}

	static Map<Integer, Integer> buildColorToCount(int[] colors) {
		Map<Integer, Integer> colorToCount = new HashMap<>();
		for (int color : colors) {
			colorToCount.put(color, colorToCount.getOrDefault(color, 0) + 1);
		}
		return colorToCount;
	}
}
