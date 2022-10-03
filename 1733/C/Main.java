import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    List<String> operations = new ArrayList<>();
    if (n != 1) {
      if (a[0] % 2 != a[n - 1] % 2) {
        a[n - 1] = a[0];
      } else {
        a[0] = a[n - 1];
      }
      operations.add(String.format("1 %d", n));

      for (int i = 1; i < a.length - 1; ++i) {
        if (a[i] % 2 != a[0] % 2) {
          operations.add(String.format("1 %d", i + 1));
        } else {
          operations.add(String.format("%d %d", i + 1, n));
        }
      }
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}
