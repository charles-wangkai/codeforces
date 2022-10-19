import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] type = new int[q];
      int[] x = new int[q];
      for (int i = 0; i < q; ++i) {
        type[i] = sc.nextInt();
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, type, x));
    }

    sc.close();
  }

  static String solve(int[] a, int[] type, int[] x) {
    long[] result = new long[type.length];
    int evenCount = (int) Arrays.stream(a).filter(ai -> ai % 2 == 0).count();
    int oddCount = a.length - evenCount;
    long sum = Arrays.stream(a).asLongStream().sum();
    for (int i = 0; i < result.length; ++i) {
      if (type[i] == 0) {
        sum += evenCount * x[i];

        if (x[i] % 2 != 0) {
          evenCount = 0;
          oddCount = a.length;
        }
      } else {
        sum += oddCount * x[i];

        if (x[i] % 2 != 0) {
          evenCount = a.length;
          oddCount = 0;
        }
      }

      result[i] = sum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}
