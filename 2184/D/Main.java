import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static int solve(int n, int k) {
    int trailing = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));

    int result = n - ((trailing + 1 <= k) ? 1 : 0);
    for (int slot = 0; slot < trailing; ++slot) {
      for (int oneNum = 0; oneNum <= slot; ++oneNum) {
        if (slot + 1 + oneNum <= k) {
          result -= C(slot, oneNum);
        }
      }
    }

    return result;
  }

  static int C(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; ++i) {
      result = result * (n - i) / (i + 1);
    }

    return (int) result;
  }
}