import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int n = a.length;

    int[] deltas = new int[n + 1];
    for (int i = 0; i < a.length; ++i) {
      if (a[i] * (i + 1) < deltas.length) {
        ++deltas[a[i] * (i + 1)];
        --deltas[Math.min(n, (a[i] + 1) * (i + 1))];
      }
    }

    List<Integer> b = new ArrayList<>();
    int covered = 0;
    for (int i = 0; i < n; ++i) {
      covered += deltas[i];
      if (covered == 0) {
        b.add(i);
      }
    }

    return "%d\n%s"
        .formatted(b.size(), b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}