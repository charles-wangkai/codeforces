import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int k) {
    Map<Integer, Integer> aValueToIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    Set<Integer> seen = new HashSet<>();
    for (int i = 0; i < b.length; ++i) {
      if (b[i] != -1) {
        if (seen.contains(b[i]) || !check(a.length, k, aValueToIndex.get(b[i]), i)) {
          return false;
        }

        seen.add(b[i]);
      }
    }

    return true;
  }

  static boolean check(int n, int k, int index1, int index2) {
    if (index1 == index2) {
      return true;
    }
    if (index1 > index2) {
      return check(n, k, index2, index1);
    }

    return k - 1 >= index2 && n - k <= index1;
  }
}