import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[k];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    boolean[] frees = buildFrees(a.length, b);

    return IntStream.range(0, a.length).filter(i -> !frees[i]).map(i -> a[i]).asLongStream().sum();
  }

  static boolean[] buildFrees(int size, int[] b) {
    boolean[] result = new boolean[size];
    int index = result.length - 1;
    for (int bi : b) {
      for (int i = 0; i < bi; ++i) {
        result[index] = i == bi - 1;
        if (index == 0) {
          return result;
        }

        --index;
      }
    }

    return result;
  }
}