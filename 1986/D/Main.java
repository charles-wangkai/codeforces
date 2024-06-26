import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return IntStream.range(0, s.length() - 1).map(i -> computeMinResult(s, i)).min().getAsInt();
  }

  static int computeMinResult(String s, int doubleGroup) {
    int index = 0;
    int[] values = new int[s.length() - 1];
    for (int i = 0; i < values.length; ++i) {
      int length = (i == doubleGroup) ? 2 : 1;
      values[i] = Integer.parseInt(s.substring(index, index + length));
      index += length;
    }

    return Arrays.stream(values).anyMatch(x -> x == 0)
        ? 0
        : Math.max(1, Arrays.stream(values).filter(x -> x != 1).sum());
  }
}