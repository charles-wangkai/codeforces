import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder out = new StringBuilder();
    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      out.append(solve(a, x) ? "YES" : "NO").append("\n");
    }
    System.out.print(out);

    sc.close();
  }

  static boolean solve(int[] a, int x) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(ai -> ai).toArray();

    for (int i = 0; i < a.length; ++i) {
      if (i - x < 0 && i + x >= a.length && a[i] != sorted[i]) {
        return false;
      }
    }

    return true;
  }
}
