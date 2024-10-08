import java.util.Scanner;

public class Main {
  static final int BIT_NUM = 61;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long b = sc.nextLong();
      long c = sc.nextLong();
      long d = sc.nextLong();

      System.out.println(solve(b, c, d));
    }

    sc.close();
  }

  static long solve(long b, long c, long d) {
    long result = 0;
    for (int i = 0; i < BIT_NUM; ++i) {
      int bit = findBit((int) ((b >> i) & 1), (int) ((c >> i) & 1), (int) ((d >> i) & 1));
      if (bit == -1) {
        return -1;
      }

      result += (long) bit << i;
    }

    return result;
  }

  static int findBit(int bBit, int cBit, int dBit) {
    for (int bit = 0; bit <= 1; ++bit) {
      if ((bit | bBit) - (bit & cBit) == dBit) {
        return bit;
      }
    }

    return -1;
  }
}