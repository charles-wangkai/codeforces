import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();
      int[] c = new int[k];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] c) {
    return Arrays.stream(c).anyMatch(ci -> ci >= 3)
        || Arrays.stream(c).filter(ci -> ci >= 2).count() >= 2;
  }
}