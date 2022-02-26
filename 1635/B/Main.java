import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    int operationCount = 0;
    for (int i = 1; i < a.length - 1; ++i) {
      if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
        if (i + 1 == a.length - 1) {
          a[i + 1] = a[i];
        } else {
          a[i + 1] = Math.max(a[i], a[i + 2]);
        }

        ++operationCount;
      }
    }

    return String.format(
        "%d\n%s",
        operationCount,
        Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}