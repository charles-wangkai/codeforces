import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < words.length; ++i) {
        words[i] = sc.next();
      }

      System.out.println(solve(words));
    }

    sc.close();
  }

  static int solve(String[] words) {
    return IntStream.of('a', 'b', 'c', 'd', 'e')
        .map(mostLetter -> computeWordNum(words, (char) mostLetter))
        .max()
        .getAsInt();
  }

  static int computeWordNum(String[] words, char mostLetter) {
    int[] deltas =
        Arrays.stream(words)
            .mapToInt(
                word -> (int) word.chars().filter(c -> c == mostLetter).count() * 2 - word.length())
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();

    int result = 0;
    int sum = 0;
    for (int delta : deltas) {
      sum += delta;
      if (sum <= 0) {
        break;
      }

      ++result;
    }

    return result;
  }
}