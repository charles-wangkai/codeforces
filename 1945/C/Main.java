import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(String a) {
    int leftZeroNum = 0;
    int rightOneNum = (int) a.chars().filter(c -> c == '1').count();
    int result = (rightOneNum * 2 >= a.length()) ? 0 : -1;
    for (int i = 0; i < a.length(); ++i) {
      if (a.charAt(i) == '0') {
        ++leftZeroNum;
      } else {
        --rightOneNum;
      }

      if (leftZeroNum * 2 >= i + 1
          && rightOneNum * 2 >= a.length() - (i + 1)
          && (result == -1
              || Math.abs(a.length() - 2 * (i + 1)) < Math.abs(a.length() - 2 * result))) {
        result = i + 1;
      }
    }

    return result;
  }
}