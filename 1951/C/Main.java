// https://codeforces.com/blog/entry/128116

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m, k));
    }

    sc.close();
  }

  static long solve(int[] a, int m, int k) {
    Arrays.sort(a);

    long result = 0;
    int beforeNum = 0;
    for (int ai : a) {
      int current = Math.min(m, k);
      result += (long) current * (ai + beforeNum);

      k -= current;
      beforeNum += current;
    }

    return result;
  }
}