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
    int x = 0;
    int y = 0;
    int[] digits = String.valueOf(n).chars().map(c -> c - '0').toArray();
    int oddCount = 0;
    for (int digit : digits) {
      int xDigit = digit / 2;
      int yDigit = digit / 2;
      if (digit % 2 == 1) {
        if (oddCount % 2 == 0) {
          ++xDigit;
        } else {
          ++yDigit;
        }

        ++oddCount;
      }

      x = x * 10 + xDigit;
      y = y * 10 + yDigit;
    }

    return String.format("%d %d", x, y);
  }
}
