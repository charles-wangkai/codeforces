import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, int k) {
    Arrays.sort(a);

    int maxFreq = 0;
    int bestValue = Integer.MIN_VALUE;
    int beginIndex = 0;
    long sum = 0;
    for (int endIndex = 0; endIndex < a.length; ++endIndex) {
      sum += a[endIndex];

      while ((endIndex - beginIndex + 1L) * a[endIndex] - sum > k) {
        sum -= a[beginIndex];
        ++beginIndex;
      }

      int freq = endIndex - beginIndex + 1;
      if (freq > maxFreq) {
        maxFreq = freq;
        bestValue = a[endIndex];
      }
    }

    return "%d %d".formatted(maxFreq, bestValue);
  }
}