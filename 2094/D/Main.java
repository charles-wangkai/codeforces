import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String p = sc.next();
      String s = sc.next();

      System.out.println(solve(p, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String p, String s) {
    List<Segment> pSegments = buildSegments(p);
    List<Segment> sSegments = buildSegments(s);

    return pSegments.size() == sSegments.size()
        && IntStream.range(0, pSegments.size())
            .allMatch(
                i ->
                    pSegments.get(i).letter() == sSegments.get(i).letter()
                        && sSegments.get(i).length() >= pSegments.get(i).length()
                        && sSegments.get(i).length() <= 2 * pSegments.get(i).length());
  }

  static List<Segment> buildSegments(String str) {
    List<Segment> result = new ArrayList<>();
    char letter = 0;
    int length = 0;
    for (int i = 0; i <= str.length(); ++i) {
      if (i != str.length() && str.charAt(i) == letter) {
        ++length;
      } else {
        if (length != 0) {
          result.add(new Segment(letter, length));
        }

        if (i != str.length()) {
          letter = str.charAt(i);
          length = 1;
        }
      }
    }

    return result;
  }
}

record Segment(char letter, int length) {}
