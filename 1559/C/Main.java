import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int[] a) {
    int n = a.length;

    List<Integer> result = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
    if (a[0] == 1) {
      result.add(0, n + 1);
    } else if (a[a.length - 1] == 0) {
      result.add(n + 1);
    } else {
      boolean found = false;
      for (int i = 0; i < n - 1; ++i) {
        if (a[i] == 0 && a[i + 1] == 1) {
          result.add(i + 1, n + 1);
          found = true;

          break;
        }
      }

      if (!found) {
        return "-1";
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
