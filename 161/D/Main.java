import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n - 1];
    int[] b = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(a, b, k));

    sc.close();
  }

  static int solve(int[] a, int[] b, int k) {
    int[] distributions = new int[a.length * 2];
    Arrays.fill(distributions, 1);

    int[] pairNums = buildPairNums(a, b, distributions);

    for (int d = 0; d < k - 1; ++d) {
      int[] nextDistributions = new int[distributions.length];
      for (int i = 0; i < a.length; ++i) {
        nextDistributions[i * 2] = pairNums[b[i]] - distributions[i * 2 + 1];
        nextDistributions[i * 2 + 1] = pairNums[a[i]] - distributions[i * 2];
      }

      distributions = nextDistributions;
      pairNums = buildPairNums(a, b, distributions);
    }

    return (int) (Arrays.stream(pairNums).asLongStream().sum() / 2);
  }

  static int[] buildPairNums(int[] a, int[] b, int[] distributions) {
    int[] result = new int[a.length + 1];
    for (int i = 0; i < a.length; ++i) {
      result[a[i]] += distributions[i * 2];
      result[b[i]] += distributions[i * 2 + 1];
    }

    return result;
  }
}
