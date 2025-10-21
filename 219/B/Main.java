import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long p = sc.nextLong();
    long d = sc.nextLong();

    System.out.println(solve(p, d));

    sc.close();
  }

  static long solve(long p, long d) {
    String s = String.valueOf(p);
    if (s.chars().allMatch(c -> c == '9')) {
      return p;
    }

    long result = p;
    for (int length = 1; length < s.length(); ++length) {
      long value = -1;
      for (int i = 0; ; ++i) {
        value =
            Long.parseLong(
                (Long.parseLong(s.substring(0, s.length() - length)) - i) + "9".repeat(length));
        if (value <= p) {
          break;
        }
      }
      if (p - value > d) {
        break;
      }

      result = value;
    }

    return result;
  }
}