import java.util.Scanner;
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
      String colors = sc.next();

      System.out.println(solve(a, colors) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, String colors) {
    int[] blueValues =
        IntStream.range(0, a.length)
            .filter(i -> colors.charAt(i) == 'B')
            .map(i -> a[i])
            .boxed()
            .sorted()
            .mapToInt(x -> x)
            .toArray();
    int[] redValues =
        IntStream.range(0, a.length)
            .filter(i -> colors.charAt(i) == 'R')
            .map(i -> a[i])
            .boxed()
            .sorted()
            .mapToInt(x -> x)
            .toArray();

    int blueIndex = 0;
    int redIndex = 0;
    for (int i = 1; i <= a.length; ++i) {
      while (blueIndex != blueValues.length && blueValues[blueIndex] < i) {
        ++blueIndex;
      }

      if (blueIndex != blueValues.length && blueValues[blueIndex] >= i) {
        ++blueIndex;
      } else if (redIndex != redValues.length && redValues[redIndex] <= i) {
        ++redIndex;
      } else {
        return false;
      }
    }

    return true;
  }
}
