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

  static int solve(int l, int r) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; r >= 1 << i; ++i) {
      int[] totalCounts = computeCounts(i, r + 1);
      int[] excludedCounts = computeCounts(i, l);
      if (totalCounts[1] != excludedCounts[1]) {
        result = Math.min(result, totalCounts[0] - excludedCounts[0]);
      }
    }

    return result;
  }

  static int[] computeCounts(int shift, int n) {
    int[] counts = {n / (1 << (shift + 1)) * (1 << shift), n / (1 << (shift + 1)) * (1 << shift)};
    int rest = n % (1 << (shift + 1));
    if (rest <= 1 << shift) {
      counts[0] += rest;
    } else {
      counts[0] += 1 << shift;
      counts[1] += rest - (1 << shift);
    }

    return counts;
  }
}