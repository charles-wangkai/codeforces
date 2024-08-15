import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String s = sc.next();

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static long solve(int[] a, String s) {
    int n = a.length;

    long[] prefixSums = new long[n + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    long result = 0;
    int leftIndex = -1;
    int rightIndex = n;
    while (true) {
      do {
        ++leftIndex;
      } while (leftIndex != n && s.charAt(leftIndex) == 'R');

      do {
        --rightIndex;
      } while (rightIndex != -1 && s.charAt(rightIndex) == 'L');

      if (leftIndex > rightIndex) {
        break;
      }

      result += prefixSums[rightIndex + 1] - prefixSums[leftIndex];
    }

    return result;
  }
}