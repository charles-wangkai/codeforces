import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, int k) {
    int[] counts = new int[k];
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        ++counts[i % k];
      }
    }

    return Arrays.stream(counts).allMatch(count -> count % 2 == 0);
  }
}