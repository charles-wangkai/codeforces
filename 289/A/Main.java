import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r, k));

    sc.close();
  }

  static int solve(int[] l, int[] r, int k) {
    return Math.floorMod(
        -IntStream.range(0, l.length).map(i -> r[i] - l[i] + 1).asLongStream().sum(), k);
  }
}