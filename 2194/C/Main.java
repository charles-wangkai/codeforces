import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String[] strips = new String[k];
      for (int i = 0; i < strips.length; ++i) {
        strips[i] = sc.next();
      }

      System.out.println(solve(strips));
    }

    sc.close();
  }

  static String solve(String[] strips) {
    int n = strips[0].length();

    boolean[][] candidates = new boolean[n][26];
    for (String strip : strips) {
      for (int i = 0; i < strip.length(); ++i) {
        candidates[i][strip.charAt(i) - 'a'] = true;
      }
    }

    List<Integer> divisors = new ArrayList<>();
    for (int i = 1; i * i <= n; ++i) {
      if (n % i == 0) {
        divisors.add(i);
        if (n / i != i) {
          divisors.add(n / i);
        }
      }
    }
    Collections.sort(divisors);

    for (int i = 0; ; ++i) {
      String result = buildDecryption(candidates, divisors.get(i));
      if (result != null) {
        return result;
      }
    }
  }

  static String buildDecryption(boolean[][] candidates, int segmentLength) {
    int n = candidates.length;

    int segmentNum = n / segmentLength;

    StringBuilder segment = new StringBuilder();
    for (int j = 0; j < segmentLength; ++j) {
      int j_ = j;
      OptionalInt index =
          IntStream.range(0, 26)
              .filter(
                  k ->
                      IntStream.range(0, segmentNum)
                          .allMatch(p -> candidates[p * segmentLength + j_][k]))
              .findAny();
      if (index.isEmpty()) {
        return null;
      }

      segment.append((char) (index.getAsInt() + 'a'));
    }

    return segment.toString().repeat(segmentNum);
  }
}