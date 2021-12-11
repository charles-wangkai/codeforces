import java.util.Arrays;
import java.util.Comparator;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int exp2 = 0;
    for (int i = 0; i < a.length; ++i) {
      while (a[i] % 2 == 0) {
        a[i] /= 2;
        ++exp2;
      }
    }

    long[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToLong(x -> x).toArray();

    for (int i = 0; i < exp2; ++i) {
      sorted[0] *= 2;
    }

    return Arrays.stream(sorted).sum();
  }
}
