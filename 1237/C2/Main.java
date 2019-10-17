import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i < points.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();

			points[i] = new Point(x, y, z);
		}
		System.out.println(solve(points));

		sc.close();
	}

	static String solve(Point[] points) {
		Map<Point, Integer> pointToIndex = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			pointToIndex.put(points[i], i);
		}

		List<String> pairs = new ArrayList<>();
		Map<Integer, List<Point>> xToPoints = new HashMap<>();
		for (Point point : points) {
			if (!xToPoints.containsKey(point.x)) {
				xToPoints.put(point.x, new ArrayList<>());
			}

			xToPoints.get(point.x).add(point);
		}

		List<Point> remains = new ArrayList<>();
		for (List<Point> pointList : xToPoints.values()) {
			if (pointList.size() > 1) {
				pointList = removeBasedOnY(pairs, pointToIndex, pointList);
			}

			if (pointList.size() == 1) {
				remains.add(pointList.get(0));
			}
		}
		Collections.sort(remains, (p1, p2) -> Integer.compare(p1.x, p2.x));

		for (int i = 0; i < remains.size(); i += 2) {
			pairs.add(buildPair(pointToIndex, remains.get(i), remains.get(i + 1)));
		}

		return String.join("\n", pairs);
	}

	static List<Point> removeBasedOnY(List<String> pairs, Map<Point, Integer> pointToIndex, List<Point> pointList) {
		Map<Integer, List<Point>> yToPoints = new HashMap<>();
		for (Point point : pointList) {
			if (!yToPoints.containsKey(point.y)) {
				yToPoints.put(point.y, new ArrayList<>());
			}

			yToPoints.get(point.y).add(point);
		}

		List<Point> remains = new ArrayList<>();
		for (List<Point> points : yToPoints.values()) {
			if (points.size() > 1) {
				points = removeBasedOnZ(pairs, pointToIndex, points);
			}

			if (points.size() == 1) {
				remains.add(points.get(0));
			}
		}
		Collections.sort(remains, (p1, p2) -> Integer.compare(p1.y, p2.y));

		for (int i = 0;; i += 2) {
			if (i == remains.size()) {
				return Collections.emptyList();
			}
			if (i + 1 == remains.size()) {
				return Arrays.asList(remains.get(i));
			}

			pairs.add(buildPair(pointToIndex, remains.get(i), remains.get(i + 1)));
		}
	}

	static List<Point> removeBasedOnZ(List<String> pairs, Map<Point, Integer> pointToIndex, List<Point> pointList) {
		Collections.sort(pointList, (p1, p2) -> Integer.compare(p1.z, p2.z));

		for (int i = 0;; i += 2) {
			if (i == pointList.size()) {
				return Collections.emptyList();
			}
			if (i + 1 == pointList.size()) {
				return Arrays.asList(pointList.get(i));
			}

			pairs.add(buildPair(pointToIndex, pointList.get(i), pointList.get(i + 1)));
		}
	}

	static String buildPair(Map<Point, Integer> pointToIndex, Point p1, Point p2) {
		return String.format("%d %d", pointToIndex.get(p1) + 1, pointToIndex.get(p2) + 1);
	}
}

class Point {
	int x;
	int y;
	int z;

	Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return x == other.x && y == other.y && z == other.z;
	}
}