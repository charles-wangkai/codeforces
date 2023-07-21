import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int q = sc.nextInt();
      String s = sc.next();
      for (int i = 0; i < q; ++i) {
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(solve(s, l, r) ? "YES" : "NO");
      }
    }

    sc.close();
  }

  static boolean solve(String s, int l, int r) {
    return IntStream.range(0, l - 1).anyMatch(i -> s.charAt(i) == s.charAt(l - 1))
        || IntStream.range(r, s.length()).anyMatch(i -> s.charAt(i) == s.charAt(r - 1));
  }
}
