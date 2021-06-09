import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static int solve(int n, int k) {
    if (k > n) {
      return 0;
    }

    return search(new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0, k);
  }

  static int search(boolean[] columns, boolean[] sums, boolean[] diffs, int r, int rest) {
    int n = columns.length;

    if (r == n) {
      return 1;
    }

    int result = 0;
    if (n - 1 - r >= rest) {
      result += search(columns, sums, diffs, r + 1, rest);
    }
    if (rest != 0) {
      for (int c = 0; c < n; ++c) {
        if (!columns[c] && !sums[r + c] && !diffs[r - c + n - 1]) {
          columns[c] = true;
          sums[r + c] = true;
          diffs[r - c + n - 1] = true;

          result += search(columns, sums, diffs, r + 1, rest - 1);

          columns[c] = false;
          sums[r + c] = false;
          diffs[r - c + n - 1] = false;
        }
      }
    }

    return result;
  }
}
