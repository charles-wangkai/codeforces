import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(x, k));
    }

    sc.close();
  }

  static int solve(int x, int k) {
    for (int y = x; ; ++y) {
      if (computeDigitSum(y) % k == 0) {
        return y;
      }
    }
  }

  static int computeDigitSum(int a) {
    return String.valueOf(a).chars().map(c -> c - '0').sum();
  }
}
