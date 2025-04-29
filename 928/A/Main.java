import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int n = sc.nextInt();
    String[] logins = new String[n];
    for (int i = 0; i < logins.length; ++i) {
      logins[i] = sc.next();
    }

    System.out.println(solve(s, logins) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String s, String[] logins) {
    return !Arrays.stream(logins)
        .map(Main::generateKey)
        .collect(Collectors.toSet())
        .contains(generateKey(s));
  }

  static String generateKey(String login) {
    return login.toLowerCase().replace('o', '0').replace('l', '1').replace('i', '1');
  }
}