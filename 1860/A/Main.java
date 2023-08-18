import java.util.Scanner;

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
    if (s.contains(")(")) {
      return String.format("YES\n%s%s", "(".repeat(s.length()), ")".repeat(s.length()));
    }
    if (s.equals("()")) {
      return "NO";
    }

    return String.format("YES\n%s", "()".repeat(s.length()));
  }
}
