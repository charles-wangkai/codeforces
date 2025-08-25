import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static long solve(int[] h) {
    int maxHeight = Arrays.stream(h).max().getAsInt();

    return Math.min(computeDayNum(h, maxHeight), computeDayNum(h, maxHeight + 1));
  }

  static long computeDayNum(int[] h, int target) {
    int[] diffs = Arrays.stream(h).map(hi -> target - hi).toArray();

    long result = -1;
    long lower = 0;
    long upper = Arrays.stream(diffs).asLongStream().sum() * 2;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(diffs, target, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] diffs, int target, long dayNum) {
    int requiredOddNum = (int) Arrays.stream(diffs).filter(diff -> diff % 2 == 1).count();

    long oneNum = (dayNum + 1) / 2;
    long twoNum = dayNum - oneNum;

    return oneNum >= requiredOddNum
        && (oneNum - requiredOddNum) + twoNum * 2
            >= Arrays.stream(diffs).map(diff -> diff / 2 * 2).asLongStream().sum();
  }
}