import java.util.Arrays;
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

  static int solve(int[] a) {
    int result = 0;
    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();
    int beginIndex = 0;
    for (int endIndex = 0; endIndex < sorted.length; ++endIndex) {
      while (sorted[endIndex] - sorted[beginIndex] > a.length - 1) {
        ++beginIndex;
      }

      result = Math.max(result, endIndex - beginIndex + 1);
    }

    return result;
  }
}