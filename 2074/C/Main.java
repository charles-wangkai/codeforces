import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int y) {
    if (Integer.bitCount(y) == 1 || Integer.bitCount(y + 1) == 1) {
      return -1;
    }

    return Integer.highestOneBit(y) * 2 - 1 - y + Integer.lowestOneBit(y);
  }
}