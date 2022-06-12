import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      sc.nextInt();
      int k = sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b, k));
    }

    sc.close();
  }

  static String solve(String a, String b, int k) {
    StringBuilder result = new StringBuilder();

    char[] aLetters = a.toCharArray();
    Arrays.sort(aLetters);

    char[] bLetters = b.toCharArray();
    Arrays.sort(bLetters);

    int aIndex = 0;
    int bIndex = 0;
    boolean lastAOrB = false;
    int count = 0;
    while (aIndex != aLetters.length && bIndex != bLetters.length) {
      if (!(count == k && lastAOrB)
          && ((count == k && !lastAOrB) || aLetters[aIndex] < bLetters[bIndex])) {
        result.append(aLetters[aIndex]);
        ++aIndex;

        if (lastAOrB) {
          ++count;
        } else {
          count = 1;
          lastAOrB = true;
        }
      } else {
        result.append(bLetters[bIndex]);
        ++bIndex;

        if (lastAOrB) {
          count = 1;
          lastAOrB = false;
        } else {
          ++count;
        }
      }
    }

    return result.toString();
  }
}