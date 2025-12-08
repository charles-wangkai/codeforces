import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(b));

    sc.close();
  }

  static int solve(int[] b) {
    if (b.length == 1) {
      return 0;
    }

    int result = Integer.MAX_VALUE;
    for (int d0 = -1; d0 <= 1; ++d0) {
      for (int d1 = -1; d1 <= 1; ++d1) {
        result = Math.min(result, computeOperationNum(b, d0, d1));
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  static int computeOperationNum(int[] b, int d0, int d1) {
    int result = ((d0 == 0) ? 0 : 1) + ((d1 == 0) ? 0 : 1);
    int diff = (b[1] + d1) - (b[0] + d0);
    int prev = b[1] + d1;
    for (int i = 2; i < b.length; ++i) {
      int curr = prev + diff;
      int delta = Math.abs(curr - b[i]);
      if (delta > 1) {
        return Integer.MAX_VALUE;
      }

      if (delta == 1) {
        ++result;
      }

      prev = curr;
    }

    return result;
  }
}