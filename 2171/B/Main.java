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
    if (a[0] == -1 && a[a.length - 1] != -1) {
      a[0] = a[a.length - 1];
    } else if (a[a.length - 1] == -1 && a[0] != -1) {
      a[a.length - 1] = a[0];
    }

    for (int i = 0; i < a.length; ++i) {
      if (a[i] == -1) {
        a[i] = 0;
      }
    }

    return "%d\n%s"
        .formatted(
            Math.abs(a[0] - a[a.length - 1]),
            Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}