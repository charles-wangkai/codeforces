import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, long k) {
    if (k % 2 == 1
        || k > IntStream.range(0, n).map(i -> Math.abs(n - i - (i + 1))).asLongStream().sum()) {
      return "No";
    }

    int[] p = IntStream.rangeClosed(1, n).toArray();
    for (int i = 0, j = p.length - 1; i < j; ++i, --j) {
      if ((j - i) * 2 < k) {
        k -= (j - i) * 2;
        swap(p, i, j);

      } else {
        swap(p, i, i + (int) k / 2);

        break;
      }
    }

    return String.format(
        "Yes\n%s", Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static void swap(int[] p, int index1, int index2) {
    int temp = p[index1];
    p[index1] = p[index2];
    p[index2] = temp;
  }
}