import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static long solve(int n, int k) {
    long total = computePrefixSum(k, n);

    int length = 0;
    int lower = 1;
    int upper = n;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      long leftSum = computePrefixSum(k, middle);
      if (leftSum <= total - leftSum) {
        length = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return Math.min(
        Math.abs(total - 2 * computePrefixSum(k, length)),
        Math.abs(total - 2 * computePrefixSum(k, length + 1)));
  }

  static long computePrefixSum(int k, int length) {
    return (long) length * k + length * (length - 1L) / 2;
  }
}