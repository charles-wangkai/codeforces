import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] cards = new int[n][m];
      for (int i = 0; i < cards.length; ++i) {
        for (int j = 0; j < cards[i].length; ++j) {
          cards[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(cards));
    }

    sc.close();
  }

  static String solve(int[][] cards) {
    for (int[] c : cards) {
      Arrays.sort(c);
    }

    return Arrays.stream(cards)
            .allMatch(
                c ->
                    IntStream.range(0, c.length - 1).allMatch(i -> c[i + 1] - c[i] == cards.length))
        ? IntStream.range(0, cards.length)
            .boxed()
            .sorted(Comparator.comparing(i -> cards[i][0]))
            .map(x -> x + 1)
            .map(String::valueOf)
            .collect(Collectors.joining(" "))
        : "-1";
  }
}