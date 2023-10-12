import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long k = sc.nextLong();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static String solve(long k) {
    String result = "";
    while (k != 0) {
      int digit = (int) (k % 9);
      result = (digit + ((digit >= 4) ? 1 : 0)) + result;

      k /= 9;
    }

    return result;
  }
}
