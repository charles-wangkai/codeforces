import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, m, k));

    sc.close();
  }

  static int solve(int[] a, int m, int k) {
    if (k >= m) {
      return 0;
    }

    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    for (int i = 0; i < sorted.length; ++i) {
      k += sorted[i] - 1;
      if (k >= m) {
        return i + 1;
      }
    }

    return -1;
  }
}