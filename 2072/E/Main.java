import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static String solve(int k) {
    List<String> points = new ArrayList<>();
    int x = 0;
    int y = 0;
    while (k != 0) {
      int size = 1;
      while ((size + 1) * size / 2 <= k) {
        ++size;
      }

      for (int i = 0; i < size; ++i) {
        points.add("%d %d".formatted(x, y));
        ++x;
      }
      ++y;

      k -= size * (size - 1) / 2;
    }

    return "%d\n%s".formatted(points.size(), String.join("\n", points));
  }
}