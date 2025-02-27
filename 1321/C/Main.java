import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    String removed = s;
    for (char c = 'z'; c > 'a'; --c) {
      char prev = (char) (c - 1);

      while (true) {
        String next =
            removed
                .replace("%c%c".formatted(prev, c), String.valueOf(prev))
                .replace("%c%c".formatted(c, prev), String.valueOf(prev));
        if (next.equals(removed)) {
          break;
        }

        removed = next;
      }
    }

    return s.length() - removed.length();
  }
}