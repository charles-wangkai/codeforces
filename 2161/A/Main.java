import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int R0 = sc.nextInt();
      int X = sc.nextInt();
      int D = sc.nextInt();
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(R0, X, D, s));
    }

    sc.close();
  }

  static int solve(int R0, int X, int D, String s) {
    int result = 0;
    int rating = R0;
    for (char c : s.toCharArray()) {
      if (c == '1' || rating < X) {
        rating = Math.max(0, rating - D);
        ++result;
      }
    }

    return result;
  }
}