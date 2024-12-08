import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int result = 1;
    int zeroNum = 1;
    while (zeroNum < n) {
      zeroNum = (zeroNum + 1) * 2;
      ++result;
    }

    return result;
  }
}