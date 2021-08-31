import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] d = new int[n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(d));
    }

    sc.close();
  }

  static long solve(int[] d) {
    int[] sorted = Arrays.stream(d).boxed().sorted().mapToInt(x -> x).toArray();

    long result = sorted[sorted.length - 1];
    long prefixSum = 0;
    for (int i = 0; i < sorted.length; ++i) {
      result -= (long) sorted[i] * i - prefixSum;
      prefixSum += sorted[i];
    }

    return result;
  }
}
