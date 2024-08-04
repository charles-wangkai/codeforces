import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int LIMIT = 1_000_000;

  static long[] prefixSquareSums;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static void precompute() {
    prefixSquareSums = new long[LIMIT + 1];
    for (int i = 1; i < prefixSquareSums.length; ++i) {
      prefixSquareSums[i] = prefixSquareSums[i - 1] + (long) i * i;
    }
  }

  static long solve(int n) {
    List<Range> ranges = new ArrayList<>();
    ranges.add(new Range(1, 1));
    while (ranges.get(ranges.size() - 1).max() < n) {
      ranges.add(
          new Range(
              ranges.get(ranges.size() - 1).max() + 1,
              ranges.get(ranges.size() - 1).max() + ranges.size() + 1));
    }

    long result = 0;
    int left = n;
    int right = n;
    for (int i = ranges.size() - 1; i >= 0; --i) {
      result += prefixSquareSums[right] - prefixSquareSums[left - 1];

      if (i != 0) {
        left = Math.max(ranges.get(i - 1).min(), left - i - 1);
        right = Math.min(ranges.get(i - 1).max(), right - i);
      }
    }

    return result;
  }
}

record Range(int min, int max) {}
