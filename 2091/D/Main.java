import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, m, k));
    }

    sc.close();
  }

  static int solve(int n, int m, int k) {
    int result = -1;
    int lower = 1;
    int upper = m;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(n, m, k, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int n, int m, int k, int benchLength) {
    return ((m + 1L) / (benchLength + 1) * benchLength
                + Math.max(0, (m + 1) % (benchLength + 1) - 1))
            * n
        >= k;
  }
}