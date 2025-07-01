import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String s) {
    return !s.contains("CC")
        && !s.contains("MM")
        && !s.contains("YY")
        && IntStream.range(0, s.length())
            .anyMatch(
                i ->
                    s.charAt(i) == '?'
                        && (i == 0
                            || i == s.length() - 1
                            || s.charAt(i - 1) == '?'
                            || s.charAt(i + 1) == '?'
                            || s.charAt(i - 1) == s.charAt(i + 1)));
  }
}