import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    for (char c1 = 'a'; ; ++c1) {
      for (char c2 = 'a'; c2 <= 'z'; ++c2) {
        for (char c3 = 'a'; c3 <= 'z'; ++c3) {
          if ((c1 - 'a' + 1) + (c2 - 'a' + 1) + (c3 - 'a' + 1) == n) {
            return String.format("%c%c%c", c1, c2, c3);
          }
        }
      }
    }
  }
}