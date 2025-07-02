import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n * (n - 1) / 2 - 1];
    int[] y = new int[n * (n - 1) / 2 - 1];
    for (int i = 0; i < n * (n - 1) / 2 - 1; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(n, x, y));

    sc.close();
  }

  static String solve(int n, int[] x, int[] y) {
    Set<Pair> seen =
        IntStream.range(0, x.length)
            .mapToObj(i -> new Pair(Math.min(x[i] - 1, y[i] - 1), Math.max(x[i] - 1, y[i] - 1)))
            .collect(Collectors.toSet());

    Pair missing = null;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        Pair pair = new Pair(i, j);
        if (!seen.contains(pair)) {
          missing = pair;
        }
      }
    }

    boolean[][] wins = new boolean[n][n];
    for (int i = 0; i < x.length; ++i) {
      wins[x[i] - 1][y[i] - 1] = true;
    }

    for (int k = 0; k < n; ++k) {
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          if (wins[i][k] && wins[k][j]) {
            wins[i][j] = true;
          }
        }
      }
    }

    return wins[missing.person1()][missing.person2()]
        ? "%d %d".formatted(missing.person1() + 1, missing.person2() + 1)
        : "%d %d".formatted(missing.person2() + 1, missing.person1() + 1);
  }
}

record Pair(int person1, int person2) {}
