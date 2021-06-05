import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[] s = new int[4];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] s) {
    int[] sorted = Arrays.stream(s).sorted().toArray();

    int final1 = Math.max(s[0], s[1]);
    int final2 = Math.max(s[2], s[3]);
    int minFinal = Math.min(final1, final2);
    int maxFinal = Math.max(final1, final2);

    return minFinal == sorted[2] && maxFinal == sorted[3];
  }
}
