import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c));
    }

    sc.close();
  }

  static int solve(int[] a, int c) {
    int result = 0;
    int[] costs = IntStream.range(0, a.length).map(i -> i + 1 + a[i]).sorted().toArray();
    for (int cost : costs) {
      if (c >= cost) {
        c -= cost;
        ++result;
      }
    }

    return result;
  }
}
