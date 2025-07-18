import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int x) {
    for (int result = 0; ; ++result) {
      if (hasCommonDigit(x, result)) {
        return result;
      }
    }
  }

  static boolean hasCommonDigit(int x, int y) {
    return String.valueOf(x).chars().distinct().count()
            + String.valueOf(y).chars().distinct().count()
        != (String.valueOf(x) + String.valueOf(y)).chars().distinct().count();
  }
}