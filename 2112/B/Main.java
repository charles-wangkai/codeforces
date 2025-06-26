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
    if (IntStream.range(0, a.length - 1).anyMatch(i -> Math.abs(a[i] - a[i + 1]) <= 1)) {
      return 0;
    }
    if (IntStream.range(0, a.length - 1).allMatch(i -> a[i] < a[i + 1])
        || IntStream.range(0, a.length - 1).allMatch(i -> a[i] > a[i + 1])) {
      return -1;
    }

    return 1;
  }
}