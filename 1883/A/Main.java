import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String code = sc.next();

      System.out.println(solve(code));
    }

    sc.close();
  }

  static int solve(String code) {
    return IntStream.range(0, code.length())
            .map(
                i ->
                    Math.abs(
                        toDigit(code.charAt(i)) - toDigit((i == 0) ? '1' : code.charAt(i - 1))))
            .sum()
        + code.length();
  }

  static int toDigit(char c) {
    return (c == '0') ? 10 : (c - '0');
  }
}
