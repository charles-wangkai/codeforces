import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    Set<Point> points =
        IntStream.range(0, x.length)
            .mapToObj(i -> new Point(x[i], y[i]))
            .collect(Collectors.toSet());

    int result = 0;
    for (int i = 0; i < x.length; ++i) {
      for (int j = i + 1; j < x.length; ++j) {
        if ((x[i] + x[j]) % 2 == 0
            && (y[i] + y[j]) % 2 == 0
            && points.contains(new Point((x[i] + x[j]) / 2, (y[i] + y[j]) / 2))) {
          ++result;
        }
      }
    }

    return result;
  }
}

record Point(int x, int y) {}
