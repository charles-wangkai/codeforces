import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    NavigableSet<Integer> components = new TreeSet<>();
    for (int pi : p) {
      if (components.isEmpty() || pi > components.last()) {
        components.add(pi);
      } else {
        int last = components.last();
        int current = components.higher(pi);
        while (current != last) {
          components.remove(current);
          current = components.higher(current);
        }
      }
    }

    return components.size();
  }
}