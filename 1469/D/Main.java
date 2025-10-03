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
    List<Integer> path = new ArrayList<>();
    path.add(n);
    while (true) {
      int last = path.getLast();
      if (last == 2) {
        break;
      }

      int root = (int) Math.floor(Math.sqrt(last));
      if (root * root < last) {
        ++root;
      }
      path.add(root);
    }

    List<String> operations = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      if (!path.contains(i)) {
        operations.add("%d %d".formatted(i, n));
      }
    }
    for (int i = 0; i < path.size() - 1; ++i) {
      operations.add("%d %d".formatted(path.get(i), path.get(i + 1)));
      operations.add("%d %d".formatted(path.get(i), path.get(i + 1)));
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }
}