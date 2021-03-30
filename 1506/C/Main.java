import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(String a, String b) {
    for (int length = a.length(); length >= 1; --length) {
      for (int beginIndex = 0; beginIndex + length <= a.length(); ++beginIndex) {
        if (b.contains(a.substring(beginIndex, beginIndex + length))) {
          return a.length() + b.length() - length * 2;
        }
      }
    }

    return a.length() + b.length();
  }
}
