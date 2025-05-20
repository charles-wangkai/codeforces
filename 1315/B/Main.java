import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int p = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(a, b, p, s));
    }

    sc.close();
  }

  static int solve(int a, int b, int p, String s) {
    long[] costs = new long[s.length()];
    for (int i = costs.length - 2; i >= 0; --i) {
      costs[i] = costs[i + 1];
      if (s.charAt(i) != ((i == costs.length - 2) ? 0 : s.charAt(i + 1))) {
        costs[i] += (s.charAt(i) == 'A') ? a : b;
      }
    }

    return IntStream.range(0, costs.length).filter(i -> costs[i] <= p).findFirst().getAsInt() + 1;
  }
}