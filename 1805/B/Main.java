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

  static String solve(String s) {
    int minLetter = s.chars().min().getAsInt();
    int lastIndex =
        IntStream.range(0, s.length()).filter(i -> s.charAt(i) == minLetter).max().getAsInt();

    return String.format(
        "%c%s%s", s.charAt(lastIndex), s.substring(0, lastIndex), s.substring(lastIndex + 1));
  }
}
