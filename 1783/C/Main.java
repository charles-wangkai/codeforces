import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(int[] a, int m) {
    int[] sorted = Arrays.stream(a).sorted().toArray();

    int winCount = 0;
    int rest = m;
    for (int x : sorted) {
      if (x <= rest) {
        rest -= x;
        ++winCount;
      }
    }

    if (winCount == a.length) {
      return 1;
    }

    int winCount_ = winCount;
    if (a[winCount]
            + IntStream.range(0, a.length)
                .filter(i -> i != winCount_)
                .map(i -> a[i])
                .sorted()
                .limit(Math.max(0, winCount - 1))
                .sum()
        <= m) {
      return a.length - winCount;
    }

    return a.length - winCount + 1;
  }
}