import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    if (k == 1) {
      if (n == 1) {
        return "a";
      }

      return "-1";
    }
    if (k > n) {
      return "-1";
    }

    char[] result = new char[n];
    Arrays.fill(result, ' ');
    result[0] = 'a';
    result[1] = 'b';
    for (int i = 0; i < k - 2; ++i) {
      result[(n - 1) - (k - 3) + i] = (char) ('c' + i);
    }
    for (int i = 2; i < (n - 1) - (k - 3); ++i) {
      result[i] = (char) ('a' + 'b' - result[i - 1]);
    }

    return new String(result);
  }
}