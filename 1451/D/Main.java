import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int d = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(d, k));
    }

    sc.close();
  }

  static String solve(int d, int k) {
    int a = 0;
    while (2 * square(a + k) <= square(d)) {
      a += k;
    }

    return (square(a) + square(a + k) <= square(d)) ? "Ashish" : "Utkarsh";
  }

  static long square(int x) {
    return (long) x * x;
  }
}