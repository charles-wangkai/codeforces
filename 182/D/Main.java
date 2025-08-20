import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s1 = sc.next();
    String s2 = sc.next();

    System.out.println(solve(s1, s2));

    sc.close();
  }

  static int solve(String s1, String s2) {
    return (int)
        IntStream.rangeClosed(1, Math.min(s1.length(), s2.length()))
            .filter(
                length ->
                    s1.length() % length == 0
                        && s2.length() % length == 0
                        && s1.substring(0, length).equals(s2.substring(0, length))
                        && check(s1, length)
                        && check(s2, length))
            .count();
  }

  static boolean check(String s, int length) {
    return IntStream.range(0, s.length()).allMatch(i -> s.charAt(i) == s.charAt(i % length));
  }
}