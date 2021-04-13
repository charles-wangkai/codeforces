import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] r = new int[n];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }

      System.out.println(solve(r));
    }

    sc.close();
  }

  static int solve(int[] r) {
    return (int) Arrays.stream(r).filter(ri -> ri != 2).count();
  }
}
