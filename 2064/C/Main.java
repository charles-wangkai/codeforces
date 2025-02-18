import java.util.Arrays;
import java.util.Scanner;

public class Main {
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

  static long solve(int[] a) {
    long result = -Arrays.stream(a).filter(x -> x < 0).asLongStream().sum();
    long rightSum = result;
    long leftSum = 0;
    for (int ai : a) {
      if (ai > 0) {
        leftSum += ai;
      } else {
        rightSum += ai;
      }

      result = Math.max(result, leftSum + rightSum);
    }

    return result;
  }
}