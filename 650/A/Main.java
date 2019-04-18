import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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

	static long solve(int[] x, int[] y) {
		return computePairNum(Arrays.stream(x).boxed().toArray(Integer[]::new))
				+ computePairNum(Arrays.stream(y).boxed().toArray(Integer[]::new)) - computePairNum(
						IntStream.range(0, x.length).mapToObj(i -> new Point(x[i], y[i])).toArray(Point[]::new));
	}

	static long computePairNum(Object[] values) {
		Map<Object, Integer> valueToCount = new HashMap<>();
		for (Object value : values) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}
		return valueToCount.values().stream().mapToLong(count -> count * (count - 1L) / 2).sum();
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}