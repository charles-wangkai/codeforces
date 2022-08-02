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
      int H = sc.nextInt();
      int M = sc.nextInt();
      int[] h = new int[n];
      int[] m = new int[n];
      for (int i = 0; i < n; ++i) {
        h[i] = sc.nextInt();
        m[i] = sc.nextInt();
      }

      System.out.println(solve(h, m, H, M));
    }

    sc.close();
  }

  static String solve(int[] h, int[] m, int H, int M) {
    Set<Integer> alarms =
        IntStream.range(0, h.length).map(i -> h[i] * 60 + m[i]).boxed().collect(Collectors.toSet());

    int duration = 0;
    int time = H * 60 + M;
    while (!alarms.contains(time)) {
      ++duration;
      time = (time + 1) % 1440;
    }

    return String.format("%d %d", duration / 60, duration % 60);
  }
}