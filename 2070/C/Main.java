import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(s, a, k));
    }

    sc.close();
  }

  static int solve(String s, int[] a, int k) {
    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(a).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(s, a, k, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(String s, int[] a, int k, int maxPenalty) {
    char[] colors = new char[s.length()];
    for (int i = 0; i < colors.length; ++i) {
      colors[i] = (a[i] <= maxPenalty) ? 0 : s.charAt(i);
    }
    for (int i = 0; i < colors.length; ++i) {
      if (colors[i] == 0) {
        colors[i] = (i == 0) ? 'R' : colors[i - 1];
      }
    }

    return IntStream.range(0, colors.length)
            .filter(i -> colors[i] == 'B' && (i == 0 || colors[i - 1] == 'R'))
            .count()
        <= k;
  }
}