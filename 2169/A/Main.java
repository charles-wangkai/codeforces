import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int[] v = new int[n];
      for (int i = 0; i < v.length; ++i) {
        v[i] = sc.nextInt();
      }

      System.out.println(solve(v, a));
    }

    sc.close();
  }

  static int solve(int[] v, int a) {
    return IntStream.of(a - 1, a + 1)
        .boxed()
        .max(Comparator.comparing(b -> computeBobPoint(v, a, b)))
        .get();
  }

  static int computeBobPoint(int[] v, int a, int b) {
    return (int) Arrays.stream(v).filter(x -> Math.abs(x - b) < Math.abs(x - a)).count();
  }
}