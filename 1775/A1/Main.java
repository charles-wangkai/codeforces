import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    return IntStream.range(1, s.length() - 1)
        .filter(i -> s.charAt(i) == 'a')
        .mapToObj(i -> String.format("%s a %s", s.substring(0, i), s.substring(i + 1)))
        .findAny()
        .orElse(
            String.format(
                "%c %s %c", s.charAt(0), s.substring(1, s.length() - 1), s.charAt(s.length() - 1)));
  }
}
