import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int d = sc.nextInt();

    System.out.println(solve(s, d));

    sc.close();
  }

  static String solve(String s, int d) {
    return s.toLowerCase()
        .chars()
        .mapToObj(c -> (char) ((c < 'a' + d) ? Character.toUpperCase(c) : c))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}