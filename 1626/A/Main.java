import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int ALPHABET_SIZE = 26;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] counts = new int[ALPHABET_SIZE];
    for (char ch : s.toCharArray()) {
      ++counts[ch - 'a'];
    }

    return String.format(
        "%s%s",
        IntStream.range(0, counts.length)
            .filter(i -> counts[i] == 2)
            .mapToObj(i -> String.valueOf((char) (i + 'a')))
            .collect(Collectors.joining())
            .repeat(2),
        IntStream.range(0, counts.length)
            .filter(i -> counts[i] == 1)
            .mapToObj(i -> String.valueOf((char) (i + 'a')))
            .collect(Collectors.joining()));
  }
}
