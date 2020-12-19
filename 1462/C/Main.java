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
    int result = Integer.MAX_VALUE;
    for (int code = 0; code < 1 << 9; ++code) {
      int value = 0;
      int digitSum = 0;
      for (int i = 0; i < 9; ++i) {
        if ((code & (1 << i)) != 0) {
          int digit = i + 1;
          value = value * 10 + digit;
          digitSum += digit;
        }
      }

      if (digitSum == x) {
        result = Math.min(result, value);
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }
}
