import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final char[] SYMBOLS = {'R', 'G', 'B'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    for (int tc = 0; tc < q; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    return IntStream.range(0, SYMBOLS.length).map(i -> computeChangeNum(s, k, i)).min().getAsInt();
  }

  static int computeChangeNum(String s, int k, int offset) {
    int[] changes =
        IntStream.range(0, s.length())
            .map(i -> (s.charAt(i) == SYMBOLS[(i + offset) % SYMBOLS.length]) ? 0 : 1)
            .toArray();

    int result = Integer.MAX_VALUE;
    int sum = IntStream.range(0, k - 1).map(i -> changes[i]).sum();
    for (int i = k - 1; i < changes.length; ++i) {
      sum += changes[i];
      result = Math.min(result, sum);
      sum -= changes[i - k + 1];
    }

    return result;
  }
}