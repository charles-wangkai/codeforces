import java.util.Arrays;
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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();
    int[] beginIndices = IntStream.range(0, a.length).filter(i -> a[i] == min).toArray();

    return Arrays.stream(beginIndices)
        .anyMatch(
            beginIndex ->
                IntStream.range(0, a.length - 1)
                    .allMatch(
                        i -> a[(beginIndex + i) % a.length] <= a[(beginIndex + i + 1) % a.length]));
  }
}