import java.util.Scanner;

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
    StringBuilder result = new StringBuilder();
    int index = 0;
    while (index != s.length()) {
      result.append(s.charAt(index));
      index = s.indexOf(s.charAt(index), index + 1) + 1;
    }

    return result.toString();
  }
}
