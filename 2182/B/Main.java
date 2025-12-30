import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int a, int b) {
    return Math.max(computeLayerNum(1, a, b), computeLayerNum(1, b, a));
  }

  static int computeLayerNum(int needed, int rest1, int rest2) {
    if (rest1 < needed) {
      return 0;
    }

    return 1 + computeLayerNum(needed * 2, rest2, rest1 - needed);
  }
}