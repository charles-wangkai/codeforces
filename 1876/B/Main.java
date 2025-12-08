import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int[] maxValues = new int[a.length];
    for (int i = 0; i < maxValues.length; ++i) {
      for (int j = i; j < maxValues.length; j += i + 1) {
        maxValues[i] = Math.max(maxValues[i], a[j]);
      }
    }

    Arrays.sort(maxValues);

    int result = 0;
    int twoPower = 1;
    for (int maxValue : maxValues) {
      result = addMod(result, multiplyMod(twoPower, maxValue));
      twoPower = multiplyMod(twoPower, 2);
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