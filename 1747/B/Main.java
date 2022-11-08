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
    for (int i = 0, j = n - 1; i <= j; ++i, --j) {
      operations.add(String.format("%d %d", i * 3 + 1, j * 3 + 3));
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}
