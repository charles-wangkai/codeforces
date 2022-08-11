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

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[] result = IntStream.range(0, n).toArray();
    int endIndex = result.length - 1;
    for (int i = result.length - 1; i >= 0; --i) {
      if (isSquare(i + endIndex)) {
        reverse(result, i, endIndex);
        endIndex = i - 1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static boolean isSquare(int x) {
    int root = (int) Math.round(Math.sqrt(x));

    return root * root == x;
  }

  static void reverse(int[] a, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}