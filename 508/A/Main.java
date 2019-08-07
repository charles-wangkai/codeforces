import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] moveXs = new int[k];
		int[] moveYs = new int[k];
		for (int i = 0; i < k; i++) {
			moveXs[i] = sc.nextInt();
			moveYs[i] = sc.nextInt();
		}
		System.out.println(solve(n, m, moveXs, moveYs));

		sc.close();
	}

	static int solve(int n, int m, int[] moveXs, int[] moveYs) {
		Set<Point> painted = new HashSet<>();
		for (int i = 0; i < moveXs.length; i++) {
			painted.add(new Point(moveXs[i], moveYs[i]));

			if (isLose(painted, moveXs[i], moveYs[i])) {
				return i + 1;
			}
		}

		return 0;
	}

	static boolean isLose(Set<Point> painted, int x, int y) {
		return IntStream.rangeClosed(-1, 0).anyMatch(offsetX -> IntStream.rangeClosed(-1, 0)
				.anyMatch(offsetY -> isSquarePainted(painted, x + offsetX, y + offsetY)));
	}

	static boolean isSquarePainted(Set<Point> painted, int minX, int minY) {
		return IntStream.rangeClosed(0, 1).allMatch(offsetX -> IntStream.rangeClosed(0, 1)
				.allMatch(offsetY -> painted.contains(new Point(minX + offsetX, minY + offsetY))));
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