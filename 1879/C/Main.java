import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 998_244_353;

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
    int minOperationNum =
        (int) IntStream.range(1, s.length()).filter(i -> s.charAt(i) == s.charAt(i - 1)).count();

    int sequenceNum = 1;
    char current = 0;
    int count = 1;
    int rest = minOperationNum;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && s.charAt(i) == current) {
        ++count;
      } else {
        if (count >= 2) {
          sequenceNum = multiplyMod(sequenceNum, CMod(rest, count - 1));
          rest -= count - 1;

          for (int j = count; j >= 2; --j) {
            sequenceNum = multiplyMod(sequenceNum, j);
          }
        }

        if (i != s.length()) {
          current = s.charAt(i);
          count = 1;
        }
      }
    }

    return String.format("%d %d", minOperationNum, sequenceNum);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int CMod(int n, int r) {
    int result = 1;
    for (int i = 0; i < r; ++i) {
      result =
          multiplyMod(
              multiplyMod(result, n - i),
              BigInteger.valueOf(i + 1).modInverse(BigInteger.valueOf(MODULUS)).intValue());
    }

    return result;
  }
}
