import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int BASE1 = 67;
  static final int BASE2 = 71;
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static final int LIMIT = 1_000_000;

  static int[] basePowers1;
  static int[] basePowers2;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < words.length; ++i) {
      words[i] = sc.next();
    }

    System.out.println(solve(words));

    sc.close();
  }

  static void precompute() {
    basePowers1 = new int[LIMIT + 1];
    basePowers1[0] = 1;

    basePowers2 = new int[LIMIT + 1];
    basePowers2[0] = 1;

    for (int i = 1; i <= LIMIT; ++i) {
      basePowers1[i] = MOD_INT.multiplyMod(basePowers1[i - 1], BASE1);
      basePowers2[i] = MOD_INT.multiplyMod(basePowers2[i - 1], BASE2);
    }
  }

  static String solve(String[] words) {
    List<Integer> prefixHashes1 = new ArrayList<>();
    prefixHashes1.add(0);

    List<Integer> prefixHashes2 = new ArrayList<>();
    prefixHashes2.add(0);

    StringBuilder result = new StringBuilder();
    for (String word : words) {
      int maxLength = 0;
      int wordHash1 = 0;
      int wordHash2 = 0;
      for (int i = 0; i < word.length() && i + 1 <= result.length(); ++i) {
        char c = word.charAt(i);

        wordHash1 = MOD_INT.addMod(MOD_INT.multiplyMod(wordHash1, BASE1), encode(c));
        wordHash2 = MOD_INT.addMod(MOD_INT.multiplyMod(wordHash2, BASE2), encode(c));

        if (wordHash1
                == computeRangeHash(
                    basePowers1, prefixHashes1, result.length() - (i + 1), result.length() - 1)
            && wordHash2
                == computeRangeHash(
                    basePowers2, prefixHashes2, result.length() - (i + 1), result.length() - 1)) {
          maxLength = i + 1;
        }
      }

      for (int i = maxLength; i < word.length(); ++i) {
        char c = word.charAt(i);

        prefixHashes1.add(
            MOD_INT.addMod(MOD_INT.multiplyMod(prefixHashes1.getLast(), BASE1), encode(c)));
        prefixHashes2.add(
            MOD_INT.addMod(MOD_INT.multiplyMod(prefixHashes2.getLast(), BASE2), encode(c)));

        result.append(c);
      }
    }

    return result.toString();
  }

  static int computeRangeHash(
      int[] basePowers, List<Integer> prefixHashes, int beginIndex, int endIndex) {
    return MOD_INT.addMod(
        prefixHashes.get(endIndex + 1),
        -MOD_INT.multiplyMod(prefixHashes.get(beginIndex), basePowers[endIndex - beginIndex + 1]));
  }

  static int encode(char c) {
    if (Character.isDigit(c)) {
      return c - '0';
    }
    if (Character.isLowerCase(c)) {
      return c - 'a' + 10;
    }

    return c - 'A' + 36;
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return Math.floorMod(x, modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return mod(x + y);
  }

  int multiplyMod(int x, int y) {
    return mod((long) x * y);
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
