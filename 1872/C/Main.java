import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int l, int r) {
    for (int sum = l; sum <= r; ++sum) {
      for (int i = 2; i * i <= sum; ++i) {
        if (sum % i == 0) {
          return String.format("%d %d", i, sum - i);
        }
      }
    }

    return "-1";
  }
}
