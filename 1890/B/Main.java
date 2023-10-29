import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      System.out.println(solve(s, t) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s, String t) {
    boolean has00 = s.contains("00");
    boolean has11 = s.contains("11");

    return (!has00 && !has11)
        || (has00
            && !has11
            && t.length() % 2 == 1
            && IntStream.range(0, t.length())
                .allMatch(i -> t.charAt(i) == ((i % 2 == 0) ? '1' : '0')))
        || (!has00
            && has11
            && t.length() % 2 == 1
            && IntStream.range(0, t.length())
                .allMatch(i -> t.charAt(i) == ((i % 2 == 0) ? '0' : '1')));
  }
}
