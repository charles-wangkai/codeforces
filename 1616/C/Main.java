import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int[] a) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      int i_ = i;
      result = Math.min(result, (int) Arrays.stream(a).filter(ai -> ai != a[i_]).count());

      for (int j = i + 1; j < a.length; ++j) {
        int j_ = j;
        result =
            Math.min(
                result,
                (int)
                    IntStream.range(0, a.length)
                        .filter(k -> (a[k] - a[i_]) * (j_ - i_) != (a[j_] - a[i_]) * (k - i_))
                        .count());
      }
    }

    return result;
  }
}