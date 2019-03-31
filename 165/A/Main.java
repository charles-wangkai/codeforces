import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static int solve(int[] x, int[] y) {
		Map<Integer, Integer> xToMinY = new HashMap<>();
		Map<Integer, Integer> xToMaxY = new HashMap<>();
		Map<Integer, Integer> yToMinX = new HashMap<>();
		Map<Integer, Integer> yToMaxX = new HashMap<>();

		for (int i = 0; i < x.length; i++) {
			xToMinY.put(x[i], Math.min(xToMinY.getOrDefault(x[i], Integer.MAX_VALUE), y[i]));
			xToMaxY.put(x[i], Math.max(xToMaxY.getOrDefault(x[i], Integer.MIN_VALUE), y[i]));
			yToMinX.put(y[i], Math.min(yToMinX.getOrDefault(y[i], Integer.MAX_VALUE), x[i]));
			yToMaxX.put(y[i], Math.max(yToMaxX.getOrDefault(y[i], Integer.MIN_VALUE), x[i]));
		}

		return (int) IntStream.range(0, x.length).filter(i -> y[i] > xToMinY.get(x[i]) && y[i] < xToMaxY.get(x[i])
				&& x[i] > yToMinX.get(y[i]) && x[i] < yToMaxX.get(y[i])).count();
	}
}
