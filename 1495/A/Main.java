import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[2 * n];
      int[] y = new int[2 * n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static double solve(int[] x, int[] y) {
    List<Long> xSquares = new ArrayList<>();
    List<Long> ySquares = new ArrayList<>();
    for (int i = 0; i < x.length; ++i) {
      if (x[i] == 0) {
        ySquares.add((long) y[i] * y[i]);
      } else {
        xSquares.add((long) x[i] * x[i]);
      }
    }

    Collections.sort(xSquares);
    Collections.sort(ySquares);

    return IntStream.range(0, xSquares.size())
        .mapToDouble(i -> Math.sqrt(xSquares.get(i) + ySquares.get(i)))
        .sum();
  }
}
