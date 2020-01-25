import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			Point[] points = new Point[n];
			for (int i = 0; i < points.length; ++i) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				points[i] = new Point(x, y);
			}

			System.out.println(solve(points));
		}

		sc.close();
	}

	static String solve(Point[] points) {
		List<Point> sorted = Stream.concat(Arrays.stream(points), Stream.of(new Point(0, 0)))
				.sorted((p1, p2) -> (p1.y != p2.y) ? Integer.compare(p1.y, p2.y) : Integer.compare(p1.x, p2.x))
				.collect(Collectors.toList());

		if (IntStream.range(0, sorted.size() - 1).anyMatch(i -> sorted.get(i).x > sorted.get(i + 1).x)) {
			return "NO";
		}

		return String.format("YES\n%s", IntStream.range(0, sorted.size() - 1)
				.mapToObj(i -> move(sorted.get(i), sorted.get(i + 1))).collect(Collectors.joining()));
	}

	static String move(Point from, Point to) {
		int x = from.x;
		int y = from.y;
		StringBuilder result = new StringBuilder();
		while (x != to.x || y != to.y) {
			if (x != to.x) {
				++x;
				result.append('R');
			} else {
				++y;
				result.append('U');
			}
		}

		return result.toString();
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}