import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return IntStream.rangeClosed(1, s.length()).filter(k -> check(s, k)).max().getAsInt();
  }

  static boolean check(String s, int k) {
    boolean[] changed = new boolean[s.length() + 1];
    boolean inverted = false;
    for (int i = 0; i < s.length(); ++i) {
      if (changed[i]) {
        inverted ^= true;
      }

      char c = s.charAt(i);
      if (inverted) {
        c = (char) ('0' + '1' - c);
      }

      if (c == '0') {
        if (i + k >= changed.length) {
          return false;
        }

        inverted ^= true;
        changed[i + k] ^= true;
      }
    }

    return true;
  }
}