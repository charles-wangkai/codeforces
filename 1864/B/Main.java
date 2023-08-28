import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static String solve(String s, int k) {
    if (k % 2 == 0) {
      return s.chars()
          .sorted()
          .mapToObj(c -> (char) c)
          .map(String::valueOf)
          .collect(Collectors.joining());
    }

    Character[] sortedEvenLetters =
        IntStream.range(0, s.length())
            .filter(i -> i % 2 == 0)
            .mapToObj(s::charAt)
            .sorted()
            .toArray(Character[]::new);
    Character[] sortedOddLetters =
        IntStream.range(0, s.length())
            .filter(i -> i % 2 == 1)
            .mapToObj(s::charAt)
            .sorted()
            .toArray(Character[]::new);
    char[] result = new char[s.length()];
    for (int i = 0; i < result.length; ++i) {
      result[i] = ((i % 2 == 0) ? sortedEvenLetters : sortedOddLetters)[i / 2];
    }

    return new String(result);
  }
}
