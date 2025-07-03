import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, k));

    sc.close();
  }

  static long solve(int[] a, int[] b, int k) {
    int[] aLengthNums = buildLengthNums(a);
    int[] bLengthNums = buildLengthNums(b);

    long result = 0;
    for (int i = 1; i < aLengthNums.length; ++i) {
      if (k % i == 0 && k / i < bLengthNums.length) {
        result += aLengthNums[i] * bLengthNums[k / i];
      }
    }

    return result;
  }

  static int[] buildLengthNums(int[] values) {
    int[] deltas = new int[values.length + 2];
    int count = 0;
    for (int value : values) {
      if (value == 1) {
        ++count;

        ++deltas[1];
        --deltas[count + 1];
      } else {
        count = 0;
      }
    }

    int[] result = new int[values.length + 1];
    int lengthNum = 0;
    for (int i = 0; i < result.length; ++i) {
      lengthNum += deltas[i];
      result[i] = lengthNum;
    }

    return result;
  }
}