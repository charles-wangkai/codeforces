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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

    return (a.length == 1 && sorted[0] == 1)
        || (a.length != 1 && sorted[sorted.length - 1] - sorted[sorted.length - 2] <= 1);
  }
}