import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int[] x) {
    for (int i = 1; i < x.length; ++i) {
      if (x[i] <= x[i - 1]) {
        ++x[i];
      }
    }

    return (int) Arrays.stream(x).distinct().count();
  }
}
