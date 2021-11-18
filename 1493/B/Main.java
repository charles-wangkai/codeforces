import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<Integer, Integer> DIGIT_TO_REFLECTION =
      Map.ofEntries(entry(0, 0), entry(1, 1), entry(2, 5), entry(5, 2), entry(8, 8));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int h = sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(h, m, s));
    }

    sc.close();
  }

  static String solve(int h, int m, String s) {
    int hour = Integer.parseInt(s.substring(0, 2));
    int minute = Integer.parseInt(s.substring(3));
    while (!check(h, m, hour, minute)) {
      ++minute;
      if (minute == m) {
        minute = 0;
        ++hour;
        if (hour == h) {
          hour = 0;
        }
      }
    }

    return String.format("%02d:%02d", hour, minute);
  }

  static boolean check(int h, int m, int hour, int minute) {
    return DIGIT_TO_REFLECTION.containsKey(hour / 10)
        && DIGIT_TO_REFLECTION.containsKey(hour % 10)
        && DIGIT_TO_REFLECTION.containsKey(minute / 10)
        && DIGIT_TO_REFLECTION.containsKey(minute % 10)
        && DIGIT_TO_REFLECTION.get(minute % 10) * 10 + DIGIT_TO_REFLECTION.get(minute / 10) < h
        && DIGIT_TO_REFLECTION.get(hour % 10) * 10 + DIGIT_TO_REFLECTION.get(hour / 10) < m;
  }
}
