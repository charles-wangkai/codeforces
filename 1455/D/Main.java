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

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    int result = 0;
    for (int i = 0; ; ++i) {
      if (IntStream.range(i, a.length).allMatch(j -> j == 0 || a[j] >= a[j - 1])) {
        return result;
      }

      if (a[i] <= x) {
        if (i == 0 || a[i] >= a[i - 1]) {
          continue;
        }

        return -1;
      }

      int temp = a[i];
      a[i] = x;
      x = temp;

      ++result;
    }
  }
}