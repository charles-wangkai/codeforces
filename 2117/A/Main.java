import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int x) {
    int[] oneIndices = IntStream.range(0, a.length).filter(i -> a[i] == 1).toArray();

    return oneIndices[oneIndices.length - 1] - oneIndices[0] + 1 <= x;
  }
}