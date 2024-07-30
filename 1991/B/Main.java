import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n - 1];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    int n = b.length + 1;

    int[] a = new int[n];
    for (int i = 0; i < b.length; ++i) {
      a[i] |= b[i];
      a[i + 1] |= b[i];
    }

    return IntStream.range(0, b.length).allMatch(i -> (a[i] & a[i + 1]) == b[i])
        ? Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        : "-1";
  }
}