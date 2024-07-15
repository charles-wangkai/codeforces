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
      int[] a = new int[n - 1];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, m));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int m) {
    int n = a.length + 1;

    Arrays.sort(a);
    Arrays.sort(b);

    int result = -1;
    int lower = 0;
    int upper = n;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, b, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int[] b, int operationNum) {
    return IntStream.range(0, b.length - operationNum)
        .allMatch(i -> ((i == 0) ? 1 : a[i - 1]) < b[operationNum + i]);
  }
}