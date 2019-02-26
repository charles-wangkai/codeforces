import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Point s = new Point(sc.next());
		Point t = new Point(sc.next());

		List<String> result = solve(s, t);
		System.out.println(result.size());
		result.stream().forEach(System.out::println);

		sc.close();
	}

	static List<String> solve(Point s, Point t) {
		List<String> result = new ArrayList<>();
		while (!(s.x == t.x && s.y == t.y)) {
			if (s.x < t.x) {
				if (s.y < t.y) {
					result.add("RU");

					s.x++;
					s.y++;
				} else if (s.y > t.y) {
					result.add("RD");

					s.x++;
					s.y--;
				} else {
					result.add("R");

					s.x++;
				}
			} else if (s.x > t.x) {
				if (s.y < t.y) {
					result.add("LU");

					s.x--;
					s.y++;
				} else if (s.y > t.y) {
					result.add("LD");

					s.x--;
					s.y--;
				} else {
					result.add("L");

					s.x--;
				}
			} else {
				if (s.y < t.y) {
					result.add("U");

					s.y++;
				} else {
					result.add("D");

					s.y--;
				}
			}
		}
		return result;
	}
}

class Point {
	int x;
	int y;

	Point(String coordinate) {
		x = coordinate.charAt(0) - 'a';
		y = coordinate.charAt(1) - '1';
	}
}