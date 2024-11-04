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

  static int solve(String s) {
    int result = -1;
    int lower = 0;
    int upper = s.length();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(s, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(String s, int cost) {
    int maxOneCount = 0;
    int beginIndex = 0;
    int zeroCount = 0;
    int oneCount = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        ++zeroCount;
      } else {
        ++oneCount;
      }

      while (zeroCount == cost + 1) {
        if (s.charAt(beginIndex) == '0') {
          --zeroCount;
        } else {
          --oneCount;
        }

        ++beginIndex;
      }

      maxOneCount = Math.max(maxOneCount, oneCount);
    }

    return s.chars().filter(c -> c == '1').count() - maxOneCount <= cost;
  }
}