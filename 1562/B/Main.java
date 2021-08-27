import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final String[] NON_PRIMES = {
    "1", "4", "6", "8", "9", "22", "25", "27", "32", "33", "35", "52", "55", "57", "72", "75", "77"
  };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String n = sc.next();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(String n) {
    return Arrays.stream(NON_PRIMES)
        .filter(nonPrime -> isSubsequence(n, nonPrime))
        .findFirst()
        .map(nonPrime -> String.format("%d\n%s", nonPrime.length(), nonPrime))
        .get();
  }

  static boolean isSubsequence(String n, String nonPrime) {
    int fromIndex = 0;
    for (char ch : nonPrime.toCharArray()) {
      int index = n.indexOf(ch, fromIndex);
      if (index == -1) {
        return false;
      }

      fromIndex = index + 1;
    }

    return true;
  }
}
