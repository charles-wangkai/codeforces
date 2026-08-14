import java.util.Scanner;

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
    int redScore = 0;
    int blueScore = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        int nextIndex = (i + 1) % s.length();
        int finalIndex = (s.charAt(nextIndex) == '1') ? i : nextIndex;

        if (finalIndex % 2 == 1) {
          ++redScore;
        } else {
          ++blueScore;
        }
      }
    }

    return "%d %d".formatted(redScore, blueScore);
  }
}