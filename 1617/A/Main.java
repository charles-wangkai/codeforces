import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String S = sc.next();
      String T = sc.next();

      System.out.println(solve(S, T));
    }

    sc.close();
  }

  static String solve(String S, String T) {
    int[] counts = new int[ALPHABET_SIZE];
    for (char ch : S.toCharArray()) {
      ++counts[ch - 'a'];
    }

    return IntStream.concat(
            (T.equals("abc") && counts[0] != 0 && counts[1] != 0 && counts[2] != 0)
                ? IntStream.of(0, 2, 1)
                : IntStream.of(0, 1, 2),
            IntStream.range(3, ALPHABET_SIZE))
        .mapToObj(i -> String.valueOf((char) (i + 'a')).repeat(counts[i]))
        .collect(Collectors.joining());
  }
}
