import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "abacaba";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int occurrenceNum = computeOccurrenceNum(s);
    if (occurrenceNum == 1) {
      return String.format("Yes\n%s", s.replace('?', 'z'));
    }
    if (occurrenceNum >= 2) {
      return "No";
    }

    for (int i = 0; i + TARGET.length() <= s.length(); ++i) {
      if (isMatched(s.substring(i, i + TARGET.length()))) {
        String replaced =
            String.format("%s%s%s", s.substring(0, i), TARGET, s.substring(i + TARGET.length()))
                .replace('?', 'z');
        if (computeOccurrenceNum(replaced) == 1) {
          return String.format("Yes\n%s", replaced);
        }
      }
    }

    return "No";
  }

  static boolean isMatched(String pattern) {
    return IntStream.range(0, pattern.length())
        .allMatch(i -> pattern.charAt(i) == '?' || pattern.charAt(i) == TARGET.charAt(i));
  }

  static int computeOccurrenceNum(String str) {
    int result = 0;
    int fromIndex = 0;
    while (true) {
      int index = str.indexOf(TARGET, fromIndex);
      if (index == -1) {
        break;
      }

      ++result;
      fromIndex = index + 1;
    }

    return result;
  }
}