import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int[] a) {
    return IntStream.range(0, a.length - 1).map(i -> computeAddedNum(a[i], a[i + 1])).sum();
  }

  static int computeAddedNum(int x, int y) {
    if (x > y) {
      return computeAddedNum(y, x);
    }
    if (x * 2 >= y) {
      return 0;
    }

    return 1 + computeAddedNum(x * 2, y);
  }
}
