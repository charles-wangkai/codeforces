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
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, a, b));
    }

    sc.close();
  }

  static String solve(int n, int a, int b) {
    if (Math.abs(a - b) >= 2 || a + b > n - 2 || Math.min(a, b) > (n - 2) / 2) {
      return "-1";
    }

    int[] result = IntStream.rangeClosed(1, n).toArray();
    if (a < b) {
      for (int i = 0; i < b; ++i) {
        swap(result, i * 2, i * 2 + 1);
      }
    } else if (a > b) {
      for (int i = 0; i < a; ++i) {
        swap(result, result.length - 1 - i * 2, result.length - 2 - i * 2);
      }
    } else {
      for (int i = 0; i < a; ++i) {
        swap(result, i * 2 + 1, i * 2 + 2);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void swap(int[] x, int index1, int index2) {
    int temp = x[index1];
    x[index1] = x[index2];
    x[index2] = temp;
  }
}
