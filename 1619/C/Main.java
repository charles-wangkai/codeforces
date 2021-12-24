import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long s = sc.nextLong();

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static long solve(long a, long s) {
    long result = 0;
    long placeValue = 1;
    while (s != 0 || a != 0) {
      int digit = (int) (s % 10 - a % 10);
      if (digit >= 0 && digit <= 9) {
        result += digit * placeValue;
        s /= 10;
      } else {
        digit = (int) (s % 100 - a % 10);
        if (digit >= 0 && digit <= 9) {
          result += digit * placeValue;
          s /= 100;
        } else {
          return -1;
        }
      }

      a /= 10;
      placeValue *= 10;
    }

    return result;
  }
}
