import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static long solve(int[] c) {
    int n = c.length;

    long result = (long) n * (c[0] + c[1]);
    int minEven = c[0];
    long evenSum = c[0];
    int evenNum = 1;
    int minOdd = c[1];
    long oddSum = c[1];
    int oddNum = 1;
    for (int i = 2; i < c.length; ++i) {
      if (i % 2 == 0) {
        minEven = Math.min(minEven, c[i]);
        evenSum += c[i];
        ++evenNum;
      } else {
        minOdd = Math.min(minOdd, c[i]);
        oddSum += c[i];
        ++oddNum;
      }

      result =
          Math.min(
              result,
              evenSum + (long) minEven * (n - evenNum) + oddSum + (long) minOdd * (n - oddNum));
    }

    return result;
  }
}