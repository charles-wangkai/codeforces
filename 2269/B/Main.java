import java.util.Scanner;

public class Main {
  static final int LIMIT = 800;

  static Boolean[][] cache = new Boolean[LIMIT][LIMIT];
  static boolean[][] visited = new boolean[LIMIT][LIMIT];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        if (isInTune(a[i], a[j])) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean isInTune(int x, int y) {
    if (x == y) {
      return true;
    }

    if (x < LIMIT && y < LIMIT) {
      if (cache[x][y] == null) {
        if (visited[x][y]) {
          cache[x][y] = false;
        } else {
          visited[x][y] = true;
          cache[x][y] = isInTune(computeNext(x), computeNext(y));
        }
      }

      return cache[x][y];
    }

    return isInTune(computeNext(x), computeNext(y));
  }

  static int computeNext(int value) {
    return String.valueOf(value).chars().map(c -> (c - '0') * (c - '0')).sum();
  }
}