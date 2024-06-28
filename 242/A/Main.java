import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.print(solve(x, y, a, b));

    sc.close();
  }

  static String solve(int x, int y, int a, int b) {
    List<String> outcomes = new ArrayList<>();
    for (int c = a; c <= x; ++c) {
      for (int d = b; d <= y && d < c; ++d) {
        outcomes.add(String.format("%d %d", c, d));
      }
    }

    return String.format("%d\n%s", outcomes.size(), String.join("\n", outcomes));
  }
}