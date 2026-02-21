import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] freqs = new int[26];
    for (char c : s.toCharArray()) {
      ++freqs[c - 'a'];
    }

    int[] sortedIndices =
        IntStream.range(0, freqs.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> freqs[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int minDiffCount = Integer.MAX_VALUE;
    String bestT = null;
    for (int letterNum = 1; letterNum <= 26; ++letterNum) {
      if (s.length() % letterNum == 0) {
        int targetFreq = s.length() / letterNum;

        Map<Character, Integer> fromLetterToCount = new HashMap<>();
        Queue<Character> toLetters = new ArrayDeque<>();
        for (int i = 0; i < sortedIndices.length; ++i) {
          char letter = (char) (sortedIndices[i] + 'a');

          int excess = freqs[sortedIndices[i]] - ((i < letterNum) ? targetFreq : 0);
          if (excess > 0) {
            for (int j = 0; j < excess; ++j) {
              updateMap(fromLetterToCount, letter, 1);
            }
          } else {
            for (int j = 0; j < -excess; ++j) {
              toLetters.offer(letter);
            }
          }
        }

        if (toLetters.size() < minDiffCount) {
          minDiffCount = toLetters.size();

          StringBuilder t = new StringBuilder();
          for (char letter : s.toCharArray()) {
            if (fromLetterToCount.containsKey(letter)) {
              updateMap(fromLetterToCount, letter, -1);
              t.append(toLetters.poll());
            } else {
              t.append(letter);
            }
          }

          bestT = t.toString();
        }
      }
    }

    return "%d\n%s".formatted(minDiffCount, bestT);
  }

  static void updateMap(Map<Character, Integer> letterToCount, char letter, int delta) {
    letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + delta);
    letterToCount.remove(letter, 0);
  }
}