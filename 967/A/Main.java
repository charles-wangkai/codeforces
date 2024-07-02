import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int s = sc.nextInt();
    int[] h = new int[n];
    int[] m = new int[n];
    for (int i = 0; i < n; ++i) {
      h[i] = sc.nextInt();
      m[i] = sc.nextInt();
    }

    System.out.println(solve(h, m, s));

    sc.close();
  }

  static String solve(int[] h, int[] m, int s) {
    int[] times = IntStream.range(0, h.length).map(i -> toTime(h[i], m[i])).toArray();
    if (times[0] >= s + 1) {
      return formatTime(0);
    }

    for (int i = 0; i < times.length - 1; ++i) {
      int time = times[i] + s + 1;
      if (times[i + 1] - time >= s + 1) {
        return formatTime(time);
      }
    }

    return formatTime(times[times.length - 1] + s + 1);
  }

  static int toTime(int hour, int minute) {
    return hour * 60 + minute;
  }

  static String formatTime(int time) {
    return "%d %d".formatted(time / 60, time % 60);
  }
}