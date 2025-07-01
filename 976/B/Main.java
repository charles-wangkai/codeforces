import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    long k = sc.nextLong();

    System.out.println(solve(n, m, k));

    sc.close();
  }

  static String solve(int n, int m, long k) {
    if (k < n) {
      return "%d 1".formatted(k + 1);
    }

    k -= n;
    int r = (int) (n - 1 - k / (m - 1));
    int cOffset = (int) (k % (m - 1));
    int c = (r % 2 == 0) ? (m - 1 - cOffset) : (cOffset + 1);

    return "%d %d".formatted(r + 1, c + 1);
  }
}