import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 29;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int[] t = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      t[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(t, v));

    sc.close();
  }

  static String solve(int[] t, int[] v) {
    List<Boolean> result = new ArrayList<>();
    int[] counts = new int[LIMIT + 1];
    for (int i = 0; i < t.length; ++i) {
      if (t[i] == 1) {
        ++counts[v[i]];
      } else {
        result.add(canGet(v[i], counts));
      }
    }

    return result.stream().map(x -> x ? "YES" : "NO").collect(Collectors.joining("\n"));
  }

  static boolean canGet(int value, int[] counts) {
    int[] bits = new int[LIMIT + 1];
    for (int i = 0; i < bits.length; ++i) {
      bits[i] = value % 2;
      value /= 2;
    }

    int needed = 0;
    for (int i = LIMIT; i >= 0; --i) {
      needed = needed * 2 + bits[i];
      needed -= Math.min(needed, counts[i]);
    }

    return needed == 0;
  }
}