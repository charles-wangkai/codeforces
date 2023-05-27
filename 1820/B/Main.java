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
    if (s.chars().allMatch(c -> c == '1')) {
      return (long) s.length() * s.length();
    }

    int maxOneLength = 0;
    int oneLength = 0;
    for (char c : (s + s).toCharArray()) {
      if (c == '1') {
        ++oneLength;
        maxOneLength = Math.max(maxOneLength, oneLength);
      } else {
        oneLength = 0;
      }
    }

    int half = (maxOneLength + 1) / 2;

    return half * (maxOneLength + 1L - half);
  }
}
