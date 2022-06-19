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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int[] counts = new int[10];
    for (int ai : a) {
      ++counts[ai % 10];
    }

    for (int d1 = 0; d1 <= 9; ++d1) {
      for (int d2 = d1; d2 <= 9; ++d2) {
        for (int d3 = d2; d3 <= 9; ++d3) {
          if ((d1 + d2 + d3) % 10 == 3
              && ((d1 == d3 && counts[d1] >= 3)
                  || (d1 == d2 && d2 != d3 && counts[d1] >= 2 && counts[d3] >= 1)
                  || (d1 != d2 && d2 == d3 && counts[d1] >= 1 && counts[d2] >= 2)
                  || (d1 != d2
                      && d2 != d3
                      && counts[d1] >= 1
                      && counts[d2] >= 1
                      && counts[d3] >= 1))) {
            return true;
          }
        }
      }
    }

    return false;
  }
}