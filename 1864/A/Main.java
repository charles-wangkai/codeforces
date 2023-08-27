import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(solve(x, y, n));
    }

    sc.close();
  }

  static String solve(int x, int y, int n) {
    int[] a = new int[n];
    a[0] = x;
    a[a.length - 1] = y;
    for (int i = a.length - 2; i >= 1; --i) {
      a[i] = a[i + 1] - (a.length - i - 1);
    }

    return (a[1] - a[0] > a[2] - a[1])
        ? Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        : "-1";
  }
}
