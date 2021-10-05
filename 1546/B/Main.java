import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      sc.nextInt();
      String[] originals = new String[n];
      for (int i = 0; i < originals.length; ++i) {
        originals[i] = sc.next();
      }
      String[] rests = new String[n - 1];
      for (int i = 0; i < rests.length; ++i) {
        rests[i] = sc.next();
      }

      System.out.println(solve(originals, rests));
      System.out.flush();
    }

    sc.close();
  }

  static String solve(String[] originals, String[] rests) {
    int m = originals[0].length();

    int[][] counts = new int[m][26];
    for (String original : originals) {
      for (int i = 0; i < original.length(); ++i) {
        ++counts[i][original.charAt(i) - 'a'];
      }
    }
    for (String rest : rests) {
      for (int i = 0; i < rest.length(); ++i) {
        --counts[i][rest.charAt(i) - 'a'];
      }
    }

    return Arrays.stream(counts)
        .map(
            c ->
                String.valueOf(
                    (char)
                        ('a'
                            + IntStream.range(0, c.length)
                                .filter(i -> c[i] == 1)
                                .findAny()
                                .getAsInt())))
        .collect(Collectors.joining());
  }
}
