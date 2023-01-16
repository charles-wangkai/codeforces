import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      int[] b = new int[k];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, m, b) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int m, int[] b) {
    return decompose(a, m).equals(decompose(b, m));
  }

  static List<Element> decompose(int[] values, int m) {
    List<Element> result = new ArrayList<>();
    for (int value : values) {
      int base = value;
      long count = 1;
      while (base % m == 0) {
        base /= m;
        count *= m;
      }

      if (!result.isEmpty() && base == result.get(result.size() - 1).base()) {
        Element last = result.remove(result.size() - 1);
        result.add(new Element(base, last.count() + count));
      } else {
        result.add(new Element(base, count));
      }
    }

    return result;
  }
}

record Element(int base, long count) {}
