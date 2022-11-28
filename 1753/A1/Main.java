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
    if (a.length % 2 != 0) {
      return "-1";
    }

    List<String> segments = new ArrayList<>();
    for (int i = 0; i < a.length; i += 2) {
      if (a[i] == a[i + 1]) {
        segments.add(String.format("%d %d", i + 1, i + 2));
      } else {
        segments.add(String.format("%d %d", i + 1, i + 1));
        segments.add(String.format("%d %d", i + 2, i + 2));
      }
    }

    return String.format("%d\n%s", segments.size(), String.join("\n", segments));
  }
}
