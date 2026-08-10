import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n) {
    return IntStream.rangeClosed(2, n).allMatch(x -> (n + 1) % x != 0);
  }
}