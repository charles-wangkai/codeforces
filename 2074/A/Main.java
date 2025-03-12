import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int d = sc.nextInt();
      int u = sc.nextInt();

      System.out.println(solve(l, r, d, u) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int l, int r, int d, int u) {
    return IntStream.of(l, r, d, u).distinct().count() == 1;
  }
}