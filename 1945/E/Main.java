import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, x));
    }

    sc.close();
  }

  static String solve(int[] p, int x) {
    List<String> operations = new ArrayList<>();
    while (true) {
      int expectedIndex = IntStream.range(0, p.length).filter(i -> p[i] == x).findAny().getAsInt();
      int actualIndex = find(p, x);
      if (actualIndex == expectedIndex) {
        break;
      }

      int temp = p[expectedIndex];
      p[expectedIndex] = p[actualIndex];
      p[actualIndex] = temp;

      operations.add("%d %d".formatted(expectedIndex + 1, actualIndex + 1));
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }

  static int find(int[] p, int x) {
    int l = 1;
    int r = p.length + 1;
    while (r - l != 1) {
      int m = (r + l) / 2;
      if (p[m - 1] <= x) {
        l = m;
      } else {
        r = m;
      }
    }

    return l - 1;
  }
}