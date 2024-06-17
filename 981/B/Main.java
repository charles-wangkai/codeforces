import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] x = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      x[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] b = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; ++i) {
      b[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(a, x, b, y));

    sc.close();
  }

  static long solve(int[] a, int[] x, int[] b, int[] y) {
    Map<Integer, Integer> elementToMaxIncome = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      elementToMaxIncome.put(a[i], x[i]);
    }
    for (int i = 0; i < b.length; ++i) {
      elementToMaxIncome.put(b[i], Math.max(elementToMaxIncome.getOrDefault(b[i], -1), y[i]));
    }

    return elementToMaxIncome.values().stream().mapToInt(Integer::intValue).asLongStream().sum();
  }
}