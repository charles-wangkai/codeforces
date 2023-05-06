import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, k));
    }

    sc.close();
  }

  static int solve(int[] p, int k) {
    int diffCount = (int) IntStream.range(0, p.length).filter(i -> (p[i] - 1) % k != i % k).count();

    return (diffCount == 0) ? 0 : ((diffCount == 2) ? 1 : -1);
  }
}
