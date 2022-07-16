import java.util.OptionalInt;
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

  static long solve(int[] a) {
    OptionalInt firstNonZeroIndex = IntStream.range(0, a.length).filter(i -> a[i] != 0).findFirst();
    if (firstNonZeroIndex.isEmpty() || firstNonZeroIndex.getAsInt() == a.length - 1) {
      return 0;
    }

    return IntStream.range(firstNonZeroIndex.getAsInt(), a.length - 1)
            .map(i -> a[i])
            .asLongStream()
            .sum()
        + IntStream.range(firstNonZeroIndex.getAsInt(), a.length - 1)
            .filter(i -> a[i] == 0)
            .count();
  }
}