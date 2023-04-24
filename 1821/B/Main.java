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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length;

    if (IntStream.range(0, n).allMatch(i -> a[i] == b[i])) {
      return String.format("%d %d", 1, n);
    }

    int beginIndex = 0;
    while (a[beginIndex] == b[beginIndex]) {
      ++beginIndex;
    }
    while (beginIndex != 0 && b[beginIndex - 1] <= b[beginIndex]) {
      --beginIndex;
    }

    int endIndex = n - 1;
    while (a[endIndex] == b[endIndex]) {
      --endIndex;
    }
    while (endIndex != n - 1 && b[endIndex + 1] >= b[endIndex]) {
      ++endIndex;
    }

    return String.format("%d %d", beginIndex + 1, endIndex + 1);
  }
}
