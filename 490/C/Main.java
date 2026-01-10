import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println(solve(s, a, b));

    sc.close();
  }

  static String solve(String s, int a, int b) {
    int[] leftRemainders = buildLeftRemainders(s, a);
    int[] rightRemainders = buildRightRemainders(s, b);

    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i + 1) != '0' && leftRemainders[i] == 0 && rightRemainders[i + 1] == 0) {
        return String.format("YES\n%s\n%s", s.substring(0, i + 1), s.substring(i + 1));
      }
    }

    return "NO";
  }

  static int[] buildLeftRemainders(String s, int a) {
    ModInt modInt = new ModInt(a);

    int[] result = new int[s.length()];
    int remainder = 0;
    for (int i = 0; i < result.length; i++) {
      remainder = modInt.addMod(modInt.multiplyMod(remainder, 10), s.charAt(i) - '0');
      result[i] = remainder;
    }

    return result;
  }

  static int[] buildRightRemainders(String s, int b) {
    ModInt modInt = new ModInt(b);

    int[] result = new int[s.length()];
    int remainder = 0;
    int placeValue = 1;
    for (int i = result.length - 1; i >= 0; i--) {
      remainder = modInt.addMod(modInt.multiplyMod(placeValue, s.charAt(i) - '0'), remainder);
      result[i] = remainder;

      placeValue = modInt.multiplyMod(placeValue, 10);
    }

    return result;
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return (int) (x % modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return Math.floorMod(x + y, modulus);
  }

  int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, modulus);
  }

  int divideMod(int x, int y) {
    return multiplyMod(x, modInv(y));
  }

  int powMod(int base, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
