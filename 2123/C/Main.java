import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[] a) {
    int[] leftMins = new int[a.length];
    leftMins[0] = Integer.MAX_VALUE;
    for (int i = 1; i < leftMins.length; ++i) {
      leftMins[i] = Math.min(leftMins[i - 1], a[i - 1]);
    }

    int[] rightMaxs = new int[a.length];
    rightMaxs[rightMaxs.length - 1] = Integer.MIN_VALUE;
    for (int i = rightMaxs.length - 2; i >= 0; --i) {
      rightMaxs[i] = Math.max(rightMaxs[i + 1], a[i + 1]);
    }

    return IntStream.range(0, a.length)
        .map(i -> (a[i] > leftMins[i] && a[i] < rightMaxs[i]) ? 0 : 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining());
  }
}