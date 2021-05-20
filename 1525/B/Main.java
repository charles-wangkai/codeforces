import java.util.Arrays;
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
    int n = a.length;

    if (IntStream.range(0, n - 1).allMatch(i -> a[i] < a[i + 1])) {
      return 0;
    }

    int min = Arrays.stream(a).min().getAsInt();
    int max = Arrays.stream(a).max().getAsInt();
    if (a[0] == min || a[n - 1] == max) {
      return 1;
    }
    if (a[0] == max && a[n - 1] == min) {
      return 3;
    }

    return 2;
  }
}
