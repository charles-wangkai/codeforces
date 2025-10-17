import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      Map<Integer, Integer> valueToIndex = new HashMap<>();
      for (int i = 0; i < x.length; ++i) {
        valueToIndex.put(x[i], i);
      }

      if (valueToIndex.size() == n) {
        int response1 = query(sc, valueToIndex.get(1) + 1, valueToIndex.get(n) + 1);
        if (response1 < n - 1) {
          output("! A");
        } else if (response1 > n - 1) {
          output("! B");
        } else {
          int response2 = query(sc, valueToIndex.get(n) + 1, valueToIndex.get(1) + 1);
          if (response2 == n - 1) {
            output("! B");
          } else {
            output("! A");
          }
        }
      } else {
        int p = 1;
        while (valueToIndex.containsKey(p)) {
          ++p;
        }

        int q = (p == n) ? 1 : (p + 1);

        if (query(sc, p, q) == 0) {
          output("! A");
        } else {
          output("! B");
        }
      }
    }

    sc.close();
  }

  static int query(Scanner sc, int p, int q) {
    output("? %d %d".formatted(p, q));

    return sc.nextInt();
  }

  static void output(String s) {
    System.out.println(s);
    System.out.flush();
  }
}