import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int result = 0;
    int oneCount = 0;
    int powerSum = 0;
    for (int ai : a) {
      if (ai == 1) {
        ++oneCount;
        powerSum = addMod(powerSum, 1);
      } else if (ai == 2) {
        powerSum = multiplyMod(powerSum, 2);
      } else {
        result = addMod(result, addMod(powerSum, -oneCount));
      }
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}