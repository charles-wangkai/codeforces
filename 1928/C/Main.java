import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static int solve(int n, int x) {
    return (int)
        Stream.concat(findKs(x, n - x).stream(), findKs(x, n + (x - 2)).stream())
            .distinct()
            .count();
  }

  static List<Integer> findKs(int x, int multiple) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i * i <= multiple; ++i) {
      if (multiple % i == 0) {
        for (int p : new int[] {i, multiple / i}) {
          Integer k = computeK(x, p);
          if (k != null) {
            result.add(k);
          }
        }
      }
    }

    return result;
  }

  static Integer computeK(int x, int p) {
    if ((p + 2) % 2 != 0) {
      return null;
    }

    int k = (p + 2) / 2;

    return (k > 1 && x <= k) ? k : null;
  }
}