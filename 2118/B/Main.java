import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    List<String> operations = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      operations.add("%d 1 %d".formatted(r + 1, r + 1));
      if (r != n - 1) {
        operations.add("%d %d %d".formatted(r + 1, r + 2, n));
      }
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }
}