import java.util.Scanner;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static int solve(int n, int m) {
    int result = 0;
    for (int b = BIT_NUM - 1; b >= 0; --b) {
      if (((((result ^ (n >> (b + 1))) << 1) + ((n >> b) & 1)) << b) + ((1 << b) - 1) <= m) {
        result = (result << 1) + 1;
      } else {
        result <<= 1;
      }
    }

    return result;
  }
}