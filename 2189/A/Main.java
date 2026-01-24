import java.util.Scanner;

public class Main {
  static int LIMIT = 1000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int h = sc.nextInt();
      int l = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, h, l));
    }

    sc.close();
  }

  static int solve(int[] a, int h, int l) {
    int[] counts = new int[LIMIT + 1];
    for (int ai : a) {
      ++counts[ai];
    }

    int result = 0;
    int nextR = h;
    int nextC = l;
    while (true) {
      while (nextR != 0 && counts[nextR] == 0) {
        --nextR;
      }
      if (nextR == 0) {
        break;
      }
      --counts[nextR];

      while (nextC != 0 && counts[nextC] == 0) {
        --nextC;
      }
      if (nextC == 0) {
        break;
      }
      --counts[nextC];

      ++result;
    }

    return result;
  }
}