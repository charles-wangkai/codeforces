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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();

    for (int i = 0; i < sorted.length; ++i) {
      if (sorted[i] - ((i == 0) ? 0 : sorted[i - 1]) != 1) {
        return (i % 2 == 0) ? "Alice" : "Bob";
      }
    }

    return (sorted.length % 2 == 1) ? "Alice" : "Bob";
  }
}