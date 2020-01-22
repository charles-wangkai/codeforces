import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	static final int MIN_COORDINATE = 0;
	static final int MAX_COORDINATE = 1_000_000_000;

	static final int[] X_OFFSETS = { -1, 0, 1, 0 };
	static final int[] Y_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Point s = readPoint(sc);
		Point[] students = new Point[n];
		for (int i = 0; i < students.length; ++i) {
			students[i] = readPoint(sc);
		}
		System.out.println(solve(s, students));

		sc.close();
	}

	static Point readPoint(Scanner sc) {
		int x = sc.nextInt();
		int y = sc.nextInt();

		return new Point(x, y);
	}

	static String solve(Point s, Point[] students) {
		int maxCount = -1;
		Point p = null;

		for (int i = 0; i < X_OFFSETS.length; ++i) {
			int px = s.x + X_OFFSETS[i];
			int py = s.y + Y_OFFSETS[i];
			if (px < MIN_COORDINATE || px > MAX_COORDINATE || py < MIN_COORDINATE || py > MAX_COORDINATE) {
				continue;
			}

			Predicate<Point> predicate;
			if (X_OFFSETS[i] == -1) {
				predicate = student -> student.x < s.x;
			} else if (X_OFFSETS[i] == 1) {
				predicate = student -> student.x > s.x;
			} else {
				if (Y_OFFSETS[i] == -1) {
					predicate = student -> student.y < s.y;
				} else {
					predicate = student -> student.y > s.y;
				}
			}

			int count = (int) Arrays.stream(students).filter(predicate).count();
			if (count > maxCount) {
				maxCount = count;
				p = new Point(px, py);
			}
		}

		return String.format("%d\n%d %d", maxCount, p.x, p.y);
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