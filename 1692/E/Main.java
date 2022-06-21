import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static int solve(int[] a, int s) {
    int[] oneIndices = IntStream.range(0, a.length).filter(i -> a[i] == 1).toArray();
    if (oneIndices.length < s) {
      return -1;
    }

    int removed = oneIndices.length - s;

    return IntStream.rangeClosed(0, removed)
        .map(
            leftNum ->
                ((leftNum == 0) ? 0 : (oneIndices[leftNum - 1] + 1))
                    + ((leftNum == removed)
                        ? 0
                        : (a.length - oneIndices[oneIndices.length - (removed - leftNum)])))
        .min()
        .getAsInt();
  }
}