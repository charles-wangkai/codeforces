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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int[] ratings = new int[2];
    int samePos = 0;
    int sameNeg = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] < b[i]) {
        ratings[1] += b[i];
      } else if (a[i] > b[i]) {
        ratings[0] += a[i];
      } else if (a[i] == 1) {
        ++samePos;
      } else if (a[i] == -1) {
        ++sameNeg;
      }
    }
    for (int i = 0; i < samePos; ++i) {
      if (ratings[0] < ratings[1]) {
        ++ratings[0];
      } else {
        ++ratings[1];
      }
    }
    for (int i = 0; i < sameNeg; ++i) {
      if (ratings[0] < ratings[1]) {
        --ratings[1];
      } else {
        --ratings[0];
      }
    }

    return Math.min(ratings[0], ratings[1]);
  }
}