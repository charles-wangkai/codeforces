import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] x = new int[q];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static String solve(int[] a, int[] x) {
    List<Integer> queries = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int xi : x) {
      if (xi < min) {
        queries.add(xi);
        min = xi;
      }
    }

    for (int i = 0; i < a.length; ++i) {
      for (int query : queries) {
        if (a[i] % (1 << query) == 0) {
          a[i] += 1 << (query - 1);
        }
      }
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
