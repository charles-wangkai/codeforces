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
    int result = 0;
    while (IntStream.range(0, a.length - 1).anyMatch(i -> a[i] > a[i + 1])) {
      int beginIndex = (result % 2 == 0) ? 0 : 1;
      for (int i = beginIndex; i + 1 < a.length; i += 2) {
        if (a[i] > a[i + 1]) {
          int temp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = temp;
        }
      }

      ++result;
    }

    return result;
  }
}
