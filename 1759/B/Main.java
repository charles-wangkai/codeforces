import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int s = sc.nextInt();
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] b, int s) {
    Set<Integer> seen = Arrays.stream(b).boxed().collect(Collectors.toSet());
    int max = Arrays.stream(b).max().getAsInt();
    int sum = 0;
    for (int i = 1; ; ++i) {
      if (!seen.contains(i)) {
        sum += i;
      }

      if (sum > s) {
        return false;
      }
      if (sum == s && i >= max) {
        return true;
      }
    }
  }
}
