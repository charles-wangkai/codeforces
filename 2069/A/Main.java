import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n - 2];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] b) {
    return !IntStream.range(0, b.length - 2)
        .anyMatch(i -> b[i] == 1 && b[i + 1] == 0 && b[i + 2] == 1);
  }
}