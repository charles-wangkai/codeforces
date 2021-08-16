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
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, k));
    }

    sc.close();
  }

  static int solve(int[] c, int k) {
    return Arrays.stream(c)
        .distinct()
        .map(color -> computeRepaintNum(c, k, color))
        .min()
        .getAsInt();
  }

  static int computeRepaintNum(int[] c, int k, int color) {
    int[] indices = IntStream.range(0, c.length).filter(i -> c[i] != color).toArray();

    int result = 0;
    int beginIndex = -k;
    for (int index : indices) {
      if (index - beginIndex + 1 > k) {
        beginIndex = index;
        ++result;
      }
    }

    return result;
  }
}
