import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 10007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int[] sorted = Arrays.stream(a).sorted().toArray();

    return IntStream.range(0, sorted.length)
        .map(i -> multiplyMod(sorted[i], sorted[sorted.length - 1 - i]))
        .reduce(Main::addMod)
        .getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}