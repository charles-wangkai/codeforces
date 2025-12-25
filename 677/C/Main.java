import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  static int[] wayNums;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static void precompute() {
    wayNums = new int[64];
    for (int i = 0; i < wayNums.length; ++i) {
      for (int j = 0; j < wayNums.length; ++j) {
        ++wayNums[i & j];
      }
    }
  }

  static int solve(String s) {
    return s.chars().reduce(1, (acc, x) -> multiplyMod(acc, wayNums[toValue((char) x)]));
  }

  static int toValue(char c) {
    if (c >= '0' && c <= '9') {
      return c - '0';
    }
    if (c >= 'A' && c <= 'Z') {
      return c - 'A' + 10;
    }
    if (c >= 'a' && c <= 'z') {
      return c - 'a' + 36;
    }
    if (c == '-') {
      return 62;
    }

    return 63;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}