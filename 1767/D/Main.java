import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    boolean[] wins = new boolean[1];
    wins[0] = true;

    for (int i = s.length() - 1; i >= 0; --i) {
      int[] prefixSums = new int[wins.length + 1];
      for (int j = 1; j < prefixSums.length; ++j) {
        prefixSums[j] = prefixSums[j - 1] + (wins[j - 1] ? 1 : 0);
      }

      boolean[] nextWins = new boolean[wins.length * 2];
      for (int j = 0; j < nextWins.length; ++j) {
        int beginIndex;
        int endIndex;
        if (s.charAt(i) == '1') {
          beginIndex = Math.max(0, wins.length - 1 - (nextWins.length - 1 - j));
          endIndex = wins.length - 1 - (nextWins.length - j) / 2;
        } else {
          beginIndex = (j + 1) / 2;
          endIndex = Math.min(wins.length - 1, j);
        }

        nextWins[j] = hasWin(prefixSums, beginIndex, endIndex);
      }

      wins = nextWins;
    }

    boolean[] wins_ = wins;
    return IntStream.range(0, wins.length)
        .filter(i -> wins_[i])
        .map(i -> i + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static boolean hasWin(int[] prefixSums, int beginIndex, int endIndex) {
    return beginIndex <= endIndex && prefixSums[endIndex + 1] - prefixSums[beginIndex] != 0;
  }
}