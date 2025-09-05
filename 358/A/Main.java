import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x) ? "yes" : "no");

    sc.close();
  }

  static boolean solve(int[] x) {
    for (int i = 0; i < x.length - 1; ++i) {
      for (int j = i + 1; j < x.length - 1; ++j) {
        if (isIntersect(x[i], x[i + 1], x[j], x[j + 1])) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isIntersect(int x1, int x2, int x3, int x4) {
    int lower1 = Math.min(x1, x2);
    int upper1 = Math.max(x1, x2);
    int lower2 = Math.min(x3, x4);
    int upper2 = Math.max(x3, x4);

    if (lower1 > lower2) {
      return isIntersect(x3, x4, x1, x2);
    }

    return lower2 > lower1 && upper1 > lower2 && upper2 > upper1;
  }
}