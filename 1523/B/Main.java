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
    List<String> actions = new ArrayList<>();
    for (int i = 0; i < a.length; i += 2) {
      actions.add(String.format("1 %d %d", i + 1, i + 2));
      actions.add(String.format("2 %d %d", i + 1, i + 2));
      actions.add(String.format("1 %d %d", i + 1, i + 2));
      actions.add(String.format("1 %d %d", i + 1, i + 2));
      actions.add(String.format("2 %d %d", i + 1, i + 2));
      actions.add(String.format("1 %d %d", i + 1, i + 2));
    }

    return String.format("%d\n%s", actions.size(), String.join("\n", actions));
  }
}
