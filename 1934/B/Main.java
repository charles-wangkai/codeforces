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

  static int solve(int n) {
    int result = n / 15 + computeMinCoinNumUpTo10(n % 15);
    if (n >= 15) {
      result = Math.min(result, n / 15 - 1 + computeMinCoinNumUpTo10(n % 15 + 15));
    }

    return result;
  }

  static int computeMinCoinNumUpTo10(int n) {
    int result = n / 10 + computeMinCoinNumUpTo6(n % 10);
    if (n >= 10) {
      result = Math.min(result, n / 10 - 1 + computeMinCoinNumUpTo6(n % 10 + 10));
    }

    return result;
  }

  static int computeMinCoinNumUpTo6(int n) {
    int result = 0;
    int rest = n;
    for (int c : new int[] {6, 3, 1}) {
      result += rest / c;
      rest %= c;
    }

    return result;
  }
}