import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int result = 0;
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '#') {
        ++count;
      } else {
        count = 0;
      }

      result = Math.max(result, Math.ceilDiv(count, 2));
    }

    return result;
  }
}