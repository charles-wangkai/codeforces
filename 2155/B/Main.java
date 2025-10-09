import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    int rest = n * n - k;
    if (rest == 1) {
      return "NO";
    }

    char[][] directions = new char[n][n];
    for (int r = 0; r < directions.length; ++r) {
      Arrays.fill(directions[r], 'D');
    }

    Point[] points =
        IntStream.range(0, n)
            .boxed()
            .flatMap(
                r ->
                    IntStream.range(0, n)
                        .mapToObj(c -> new Point(r, (r % 2 == 0) ? c : (n - 1 - c))))
            .toArray(Point[]::new);

    int index = 0;
    while (rest != 0) {
      if (rest == 1) {
        directions[points[index].r()][points[index].c()] =
            getDirection(points[index], points[index - 1]);

        --rest;
      } else {
        directions[points[index].r()][points[index].c()] =
            getDirection(points[index], points[index + 1]);
        directions[points[index + 1].r()][points[index + 1].c()] =
            getDirection(points[index + 1], points[index]);

        rest -= 2;
        index += 2;
      }
    }

    return "YES\n%s"
        .formatted(Arrays.stream(directions).map(String::new).collect(Collectors.joining("\n")));
  }

  static char getDirection(Point from, Point to) {
    if (to.r() == from.r() - 1) {
      return 'U';
    }
    if (to.r() == from.r() + 1) {
      return 'D';
    }
    if (to.c() == from.c() - 1) {
      return 'L';
    }

    return 'R';
  }
}

record Point(int r, int c) {}
