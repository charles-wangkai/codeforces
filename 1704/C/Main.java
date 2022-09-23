import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, a));
    }

    sc.close();
  }

  static int solve(int n, int[] a) {
    Arrays.sort(a);
    int[] gaps =
        IntStream.concat(
                IntStream.of(a[0] + n - a[a.length - 1] - 1),
                IntStream.range(0, a.length - 1).map(i -> a[i + 1] - a[i] - 1))
            .filter(x -> x != 0)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();

    int result = a.length;
    int protectedNum = 0;
    for (int gap : gaps) {
      result += Math.min(gap, 2 * protectedNum);
      gap -= 2 * protectedNum;
      if (gap == 1 || gap == 2) {
        result += gap - 1;
        ++protectedNum;
      } else if (gap >= 3) {
        ++result;
        protectedNum += 2;
      }
    }

    return result;
  }
}