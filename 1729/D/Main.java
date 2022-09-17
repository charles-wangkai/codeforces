import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }
      int[] y = new int[n];
      for (int i = 0; i < y.length; ++i) {
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    int result = 0;
    int[] diffs = IntStream.range(0, x.length).map(i -> y[i] - x[i]).sorted().toArray();
    int leftIndex = 0;
    int rightIndex = x.length - 1;
    while (true) {
      while (leftIndex < rightIndex && diffs[leftIndex] + diffs[rightIndex] < 0) {
        ++leftIndex;
      }
      if (leftIndex >= rightIndex) {
        break;
      }

      ++result;
      ++leftIndex;
      --rightIndex;
    }

    return result;
  }
}