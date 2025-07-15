import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static int solve(int l, int r) {
    String lStr = String.valueOf(l);
    String rStr = String.valueOf(r);

    List<String> candidates = new ArrayList<>();
    String candidate = "";
    for (int i = 0; ; ++i) {
      if (i == lStr.length()) {
        candidates.add(candidate);

        break;
      }

      int lDigit = lStr.charAt(i) - '0';
      int rDigit = rStr.charAt(i) - '0';
      if (lDigit == rDigit) {
        candidate += lDigit;
      } else {
        if (lDigit + 1 < rDigit) {
          candidates.add(candidate);
        } else {
          String lCandidate = candidate + lDigit;
          for (int j = i + 1; j < lStr.length() && lStr.charAt(j) == '9'; ++j) {
            lCandidate += lStr.charAt(j);
          }
          candidates.add(lCandidate);

          String rCandidate = candidate + rDigit;
          for (int j = i + 1; j < rStr.length() && rStr.charAt(j) == '0'; ++j) {
            rCandidate += rStr.charAt(j);
          }
          candidates.add(rCandidate);
        }

        break;
      }
    }

    return candidates.stream()
        .mapToInt(
            c ->
                IntStream.range(0, c.length())
                    .map(
                        i ->
                            ((c.charAt(i) == lStr.charAt(i)) ? 1 : 0)
                                + ((c.charAt(i) == rStr.charAt(i)) ? 1 : 0))
                    .sum())
        .min()
        .getAsInt();
  }
}