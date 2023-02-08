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
    int alice = 0;
    int bob = 0;
    for (int i = 1; n != 0; ++i) {
      int dealNum = Math.min(i, n);
      n -= dealNum;

      if (i % 4 <= 1) {
        alice += dealNum;
      } else {
        bob += dealNum;
      }
    }

    return String.format("%d %d", alice, bob);
  }
}
