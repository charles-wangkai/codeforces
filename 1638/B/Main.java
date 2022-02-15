import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder out = new StringBuilder();
    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      out.append(solve(a) ? "Yes" : "No").append("\n");
    }
    System.out.print(out);

    sc.close();
  }

  static boolean solve(int[] a) {
    return isSorted(Arrays.stream(a).filter(x -> x % 2 == 0).toArray())
        && isSorted(Arrays.stream(a).filter(x -> x % 2 != 0).toArray());
  }

  static boolean isSorted(int[] values) {
    return IntStream.range(0, values.length - 1).allMatch(i -> values[i] <= values[i + 1]);
  }
}