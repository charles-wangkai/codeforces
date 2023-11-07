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
    List<String> operations = new ArrayList<>();
    while (true) {
      boolean changed = false;
      for (int i = 0; i < a.length; ++i) {
        for (int j = i + 1; j < a.length; ++j) {
          while (a[i] != a[j]) {
            if (a[i] == 1 || a[j] == 1) {
              return "-1";
            }

            if (a[i] < a[j]) {
              a[j] = (a[j] + a[i] - 1) / a[i];
              operations.add(String.format("%d %d", j + 1, i + 1));
            } else {
              a[i] = (a[i] + a[j] - 1) / a[j];
              operations.add(String.format("%d %d", i + 1, j + 1));
            }
          }
        }
      }

      if (!changed) {
        break;
      }
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}
