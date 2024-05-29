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
    return IntStream.range(0, a.length)
        .filter(
            i ->
                IntStream.rangeClosed(-2, 2)
                    .filter(offset -> offset != 0 && i + offset >= 0 && i + offset < a.length)
                    .anyMatch(offset -> a[i + offset] >= a[i]))
        .map(i -> a[i])
        .max()
        .getAsInt();
  }
}