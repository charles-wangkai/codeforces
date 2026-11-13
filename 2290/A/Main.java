import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a, int b, int c) {
    int[] sorted = IntStream.of(a, b, c).sorted().toArray();

    return sorted[0] + 1 == sorted[1] && sorted[1] + 1 == sorted[2];
  }
}