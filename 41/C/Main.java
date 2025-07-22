import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return (s.length() < 2)
        ? s
        : "%c%s%c"
            .formatted(
                s.charAt(0),
                s.substring(1, s.length() - 1).replace("dot", ".").replaceFirst("at", "@"),
                s.charAt(s.length() - 1));
  }
}