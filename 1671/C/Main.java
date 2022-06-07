import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static long solve(int[] a, int x) {
    int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(ai -> ai).toArray();

    int[] dayNums = new int[sorted.length];
    long sum = 0;
    for (int i = 0; i < dayNums.length; ++i) {
      sum += sorted[i];
      dayNums[i] = (sum > x) ? 0 : (1 + (int) (x - sum) / (i + 1));
    }

    long result = 0;
    int last = 0;
    for (int i = dayNums.length - 1; i >= 0; --i) {
      if (dayNums[i] > last) {
        result += (dayNums[i] - last) * (i + 1L);
        last = dayNums[i];
      }
    }

    return result;
  }
}