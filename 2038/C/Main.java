import java.util.ArrayList;
import java.util.Arrays;
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
    Arrays.sort(a);

    List<Integer> values = new ArrayList<>();
    int index = 0;
    while (index != a.length) {
      if (index != a.length - 1 && a[index] == a[index + 1]) {
        values.add(a[index]);
        index += 2;
      } else {
        ++index;
      }
    }

    if (values.size() < 4) {
      return "NO";
    }

    int xMin = values.get(0);
    int yMin = values.get(1);
    int xMax = values.get(values.size() - 2);
    int yMax = values.get(values.size() - 1);

    return "YES\n%d %d %d %d %d %d %d %d".formatted(xMin, yMin, xMin, yMax, xMax, yMin, xMax, yMax);
  }
}