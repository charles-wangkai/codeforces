import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String T = sc.next();

      System.out.println(solve(T));
    }

    sc.close();
  }

  static long solve(String T) {
    int n = T.length();

    int[] costs = new int[n];
    for (int i = 1; i <= n; ++i) {
      for (int j = i; j <= n && T.charAt(j - 1) == '0'; j += i) {
        if (costs[j - 1] == 0) {
          costs[j - 1] = i;
        }
      }
    }

    return Arrays.stream(costs).asLongStream().sum();
  }
}
