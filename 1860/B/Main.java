import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int k = sc.nextInt();
      int a1 = sc.nextInt();
      int ak = sc.nextInt();

      System.out.println(solve(m, k, a1, ak));
    }

    sc.close();
  }

  static int solve(int m, int k, int a1, int ak) {
    int result;
    if (m % k > a1) {
      result = m % k - a1;
    } else {
      result = 0;
      ak += (a1 - m % k) / k;
    }

    result += Math.max(0, m / k - ak);

    return result;
  }
}
