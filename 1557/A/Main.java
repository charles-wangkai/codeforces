import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(String.format("%.9f", solve(a)));
    }

    sc.close();
  }

  static double solve(int[] a) {
    int max = Arrays.stream(a).max().getAsInt();
    long otherSum = Arrays.stream(a).asLongStream().sum() - max;

    return max + otherSum / (a.length - 1.0);
  }
}
