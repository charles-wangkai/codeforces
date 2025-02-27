import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p) {
    for (int i = 0; i < p.length - 1; ++i) {
      if (p[i] - p[i + 1] == 1) {
        int temp = p[i];
        p[i] = p[i + 1];
        p[i + 1] = temp;
      }
    }

    return IntStream.range(0, p.length - 1).allMatch(i -> p[i] < p[i + 1]);
  }
}