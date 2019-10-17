import java.util.ArrayList;
import java.util.List;
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
		int n = points.length;

		List<String> result = new ArrayList<>();
		boolean[] removed = new boolean[n];
		for (int i = 0; i < n / 2; i++) {
			int index1 = -1;
			int index2 = -1;

			for (int j = 0; j < n; j++) {
				if (!removed[j]) {
					if (index1 == -1) {
						index1 = j;
					} else if (index2 == -1 || isInBox(points[index1], points[index2], points[j])) {
						index2 = j;
					}
				}
			}

			removed[index1] = true;
			removed[index2] = true;
			result.add(String.format("%d %d", index1 + 1, index2 + 1));
		}

		return String.join("\n", result);
	}

	static boolean isInBox(Point a, Point b, Point c) {
		return isBetween(a.x, b.x, c.x) && isBetween(a.y, b.y, c.y) && isBetween(a.z, b.z, c.z);
	}

	static boolean isBetween(int a, int b, int c) {
		return c >= Math.min(a, b) && c <= Math.max(a, b);
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
}