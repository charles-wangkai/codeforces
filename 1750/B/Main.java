import java.util.Scanner;

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

  static long solve(String s) {
    int zeroCount = (int) s.chars().filter(c -> c == '0').count();

    long result = (long) zeroCount * (s.length() - zeroCount);
    char prev = 0;
    int length = 0;
    for (char c : s.toCharArray()) {
      if (c == prev) {
        ++length;
      } else {
        prev = c;
        length = 1;
      }

      result = Math.max(result, (long) length * length);
    }

    return result;
  }
}
