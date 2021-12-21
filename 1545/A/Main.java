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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] evenSorted =
        IntStream.range(0, a.length)
            .filter(i -> i % 2 == 0)
            .map(i -> a[i])
            .boxed()
            .sorted()
            .mapToInt(x -> x)
            .toArray();
    int[] oddSorted =
        IntStream.range(0, a.length)
            .filter(i -> i % 2 != 0)
            .map(i -> a[i])
            .boxed()
            .sorted()
            .mapToInt(x -> x)
            .toArray();

    int[] combined =
        IntStream.range(0, a.length)
            .map(i -> (i % 2 == 0) ? evenSorted[i / 2] : oddSorted[i / 2])
            .toArray();

    return IntStream.range(0, combined.length - 1).allMatch(i -> combined[i] <= combined[i + 1]);
  }
}
