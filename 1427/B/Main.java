import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    k = Math.min(k, (int) s.chars().filter(c -> c == 'L').count());
    if (s.chars().allMatch(c -> c == 'L')) {
      return (k == 0) ? 0 : (2 * k - 1);
    }

    int result =
        IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == 'W')
                .map(i -> (i != 0 && s.charAt(i - 1) == 'W') ? 2 : 1)
                .sum()
            + k * 2;

    List<Integer> gaps = new ArrayList<>();
    boolean winFound = false;
    int gap = 0;
    for (char c : s.toCharArray()) {
      if (c == 'W') {
        if (gap != 0 && winFound) {
          gaps.add(gap);
        }
        gap = 0;
        winFound = true;
      } else {
        ++gap;
      }
    }

    Collections.sort(gaps);
    for (int g : gaps) {
      if (k >= g) {
        k -= g;
        ++result;
      }
    }

    return result;
  }
}
