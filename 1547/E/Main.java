import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[k];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt() - 1;
      }
      int[] t = new int[k];
      for (int i = 0; i < t.length; ++i) {
        t[i] = sc.nextInt();
      }

      System.out.println(solve(n, a, t));
    }

    sc.close();
  }

  static String solve(int n, int[] a, int[] t) {
    int[] temperatures = new int[n];
    for (int i = 0; i < a.length; ++i) {
      temperatures[a[i]] = t[i];
    }

    int[] leftMins = new int[n];
    int leftMin = Integer.MAX_VALUE;
    for (int i = 0; i < leftMins.length; ++i) {
      if (leftMin != Integer.MAX_VALUE) {
        ++leftMin;
      }
      if (temperatures[i] != 0) {
        leftMin = Math.min(leftMin, temperatures[i]);
      }

      leftMins[i] = leftMin;
    }

    int[] rightMins = new int[n];
    int rightMin = Integer.MAX_VALUE;
    for (int i = rightMins.length - 1; i >= 0; --i) {
      if (rightMin != Integer.MAX_VALUE) {
        ++rightMin;
      }
      if (temperatures[i] != 0) {
        rightMin = Math.min(rightMin, temperatures[i]);
      }

      rightMins[i] = rightMin;
    }

    return IntStream.range(0, n)
        .map(i -> Math.min(leftMins[i], rightMins[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}