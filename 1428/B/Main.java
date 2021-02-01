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
    if (s.chars().allMatch(ch -> ch == '-' || ch == '>')
        || s.chars().allMatch(ch -> ch == '-' || ch == '<')) {
      return s.length();
    }

    return (int)
        IntStream.range(0, s.length())
            .filter(i -> s.charAt(i) == '-' || s.charAt((i + 1) % s.length()) == '-')
            .count();
  }
}
