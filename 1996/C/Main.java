import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int q = sc.nextInt();
      String a = sc.next();
      String b = sc.next();
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, l, r));
    }

    sc.close();
  }

  static String solve(String a, String b, int[] l, int[] r) {
    int[][] aPrefixSums = buildPrefixSums(a);
    int[][] bPrefixSums = buildPrefixSums(b);

    return IntStream.range(0, l.length)
        .map(
            i ->
                IntStream.range(0, ALPHABET_SIZE)
                    .map(
                        j ->
                            (bPrefixSums[r[i]][j] - bPrefixSums[l[i] - 1][j])
                                - (aPrefixSums[r[i]][j] - aPrefixSums[l[i] - 1][j]))
                    .filter(x -> x >= 0)
                    .sum())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int[][] buildPrefixSums(String s) {
    int[][] result = new int[s.length() + 1][ALPHABET_SIZE];
    for (int i = 0; i < s.length(); ++i) {
      for (int j = 0; j < ALPHABET_SIZE; ++j) {
        result[i + 1][j] = result[i][j] + ((j == s.charAt(i) - 'a') ? 1 : 0);
      }
    }

    return result;
  }
}