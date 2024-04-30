import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < p.length; ++i) {
      for (int j = i + 1; j < p.length; ++j) {
        result = Math.min(result, (int) IntStream.of(i + 1, p[i], j + 1, p[j]).distinct().count());
      }
    }

    return result;
  }
}