import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(String a, String b) {
    int result = 0;
    for (char c : b.toCharArray()) {
      if (result != a.length() && a.charAt(result) == c) {
        ++result;
      }
    }

    return result;
  }
}