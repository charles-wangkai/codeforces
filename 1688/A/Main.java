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

  static int solve(int x) {
    return Integer.lowestOneBit(x)
        + ((Integer.bitCount(x) == 1) ? Integer.lowestOneBit(x ^ Integer.MAX_VALUE) : 0);
  }
}