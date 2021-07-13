import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(String s) {
    int[][] counts = new int[2][2];

    long result = 0;
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < s.length(); ++beginIndex) {
      if (beginIndex != 0 && s.charAt(beginIndex - 1) != '?') {
        --counts[(beginIndex - 1) % 2][s.charAt(beginIndex - 1) - '0'];
      }

      while (endIndex + 1 != s.length()
          && (s.charAt(endIndex + 1) == '?'
              || (s.charAt(endIndex + 1) == '0'
                  && counts[(endIndex + 1) % 2][1] == 0
                  && counts[(endIndex + 2) % 2][0] == 0)
              || (s.charAt(endIndex + 1) == '1'
                  && counts[(endIndex + 1) % 2][0] == 0
                  && counts[(endIndex + 2) % 2][1] == 0))) {
        if (s.charAt(endIndex + 1) != '?') {
          ++counts[(endIndex + 1) % 2][s.charAt(endIndex + 1) - '0'];
        }

        ++endIndex;
      }

      result += endIndex - beginIndex + 1;
    }

    return result;
  }
}
