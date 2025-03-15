import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static long limit;
  static int minOperationNum;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long x = sc.nextLong();

    System.out.println(solve(n, x));

    sc.close();
  }

  static int solve(int n, long x) {
    limit = 1;
    for (int i = 0; i < n - 1; ++i) {
      limit *= 10;
    }
    minOperationNum = Integer.MAX_VALUE;
    search(n, BigInteger.valueOf(x), 0);

    return (minOperationNum == Integer.MAX_VALUE) ? -1 : minOperationNum;
  }

  static void search(int n, BigInteger value, int operationNum) {
    if (value.compareTo(BigInteger.valueOf(limit)) >= 0) {
      minOperationNum = Math.min(minOperationNum, operationNum);
    } else if (isPossible(value, minOperationNum - operationNum - 1)) {
      Set<Integer> digits = new HashSet<>();
      BigInteger rest = value;
      while (!rest.equals(BigInteger.ZERO)) {
        int digit = rest.mod(BigInteger.TEN).intValue();
        if (digit >= 2) {
          digits.add(digit);
        }

        rest = rest.divide(BigInteger.TEN);
      }

      for (int digit : digits) {
        search(n, value.multiply(BigInteger.valueOf(digit)), operationNum + 1);
      }
    }
  }

  static boolean isPossible(BigInteger value, int step) {
    for (int i = 0; i < step; ++i) {
      value = value.multiply(BigInteger.valueOf(9));
      if (value.compareTo(BigInteger.valueOf(limit)) >= 0) {
        return true;
      }
    }

    return false;
  }
}