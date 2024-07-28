import java.util.Scanner;

public class Main {
  static final int BASE = 31;
  static final int MODULUS1 = 1_000_000_007;
  static final int MODULUS2 = 999_983;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int commonLength = 0;
    while ((commonLength + 1) * 2 <= s.length()
        && s.charAt(commonLength) == s.charAt(s.length() - 1 - commonLength)) {
      ++commonLength;
    }

    String middle = s.substring(commonLength, s.length() - commonLength);
    String longestPrefixPalindrome1 = findLongestPrefixPalindrome(middle);
    String longestPrefixPalindrome2 =
        findLongestPrefixPalindrome(new StringBuilder(middle).reverse().toString());

    return s.substring(0, commonLength)
        + ((longestPrefixPalindrome1.length() > longestPrefixPalindrome2.length())
            ? longestPrefixPalindrome1
            : longestPrefixPalindrome2)
        + s.substring(s.length() - commonLength);
  }

  static String findLongestPrefixPalindrome(String str) {
    int maxLength = 0;
    int forwardHash1 = 0;
    int forwardHash2 = 0;
    int backwardHash1 = 0;
    int backwardHash2 = 0;
    int basePower1 = 1;
    int basePower2 = 1;
    for (int i = 0; i < str.length(); ++i) {
      int h = str.charAt(i) - 'a';

      forwardHash1 = addMod(multiplyMod(forwardHash1, BASE, MODULUS1), h, MODULUS1);
      forwardHash2 = addMod(multiplyMod(forwardHash2, BASE, MODULUS2), h, MODULUS2);

      backwardHash1 = addMod(backwardHash1, multiplyMod(h, basePower1, MODULUS1), MODULUS1);
      basePower1 = multiplyMod(basePower1, BASE, MODULUS1);

      backwardHash2 = addMod(backwardHash2, multiplyMod(h, basePower2, MODULUS2), MODULUS2);
      basePower2 = multiplyMod(basePower2, BASE, MODULUS2);

      if (forwardHash1 == backwardHash1 && forwardHash2 == backwardHash2) {
        maxLength = i + 1;
      }
    }

    return str.substring(0, maxLength);
  }

  static int addMod(int x, int y, int m) {
    return Math.floorMod(x + y, m);
  }

  static int multiplyMod(int x, int y, int m) {
    return Math.floorMod((long) x * y, m);
  }
}