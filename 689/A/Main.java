import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final Point[] POINTS = {
    new Point(3, 1),
    new Point(0, 0),
    new Point(0, 1),
    new Point(0, 2),
    new Point(1, 0),
    new Point(1, 1),
    new Point(1, 2),
    new Point(2, 0),
    new Point(2, 1),
    new Point(2, 2)
  };
  static final Set<Point> POINT_SET = Arrays.stream(POINTS).collect(Collectors.toSet());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String s) {
    return !IntStream.range(0, POINTS.length)
        .anyMatch(firstDigit -> s.charAt(0) - '0' != firstDigit && check(s, firstDigit));
  }

  static boolean check(String s, int firstDigit) {
    Point current = POINTS[firstDigit];
    for (int i = 0; i < s.length() - 1; ++i) {
      Point p1 = POINTS[s.charAt(i) - '0'];
      Point p2 = POINTS[s.charAt(i + 1) - '0'];

      current = new Point(current.r() + (p2.r() - p1.r()), current.c() + (p2.c() - p1.c()));
      if (!POINT_SET.contains(current)) {
        return false;
      }
    }

    return true;
  }
}

record Point(int r, int c) {}
