import java.util.Comparator;
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

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    int n = a.length;

    if (IntStream.range(0, n).anyMatch(i -> a[i] > b[i])) {
      return false;
    }

    int indexWithMaxValue =
        IntStream.range(0, a.length).boxed().max(Comparator.comparing(i -> a[i])).get();
    if (a[indexWithMaxValue] == b[indexWithMaxValue] && check(a, b, indexWithMaxValue)) {
      return true;
    }

    int indexWithMinValue =
        IntStream.range(0, b.length).boxed().min(Comparator.comparing(i -> b[i])).get();
    a[indexWithMinValue] = b[indexWithMinValue];

    return check(a, b, indexWithMinValue);
  }

  static boolean check(int[] a, int[] b, int beginIndex) {
    int n = a.length;

    for (int i = 1; i < n; ++i) {
      int index = Math.floorMod(beginIndex - i, n);
      a[index] += Math.max(0, Math.min(b[index], a[Math.floorMod(index + 1, n)] + 1) - a[index]);
      if (a[index] != b[index]) {
        return false;
      }
    }

    return true;
  }
}
