import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

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
    int and = Arrays.stream(a).reduce((x, y) -> x & y).getAsInt();
    int count = (int) Arrays.stream(a).filter(x -> x == and).count();

    return (count <= 1)
        ? 0
        : multiplyMod(
            multiplyMod(count, count - 1),
            IntStream.range(0, a.length - 2).reduce(1, (r, i) -> multiplyMod(r, a.length - 2 - i)));
  }

  static int multiplyMod(int x, int y) {
    return (int) ((long) x * y % MODULUS);
  }
}