import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int x) {
    return IntStream.range(0, 11).anyMatch(i -> x >= i * 111 && (x - i * 111) % 11 == 0);
  }
}
