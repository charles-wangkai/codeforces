import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(a, b, x));
    }

    sc.close();
  }

  static int solve(int a, int b, int x) {
    int result = Integer.MAX_VALUE;
    int divideCountA = 0;
    while (true) {
      int divideCountB = 0;
      int restB = b;
      while (true) {
        result = Math.min(result, divideCountA + divideCountB + Math.abs(a - restB));

        if (restB == 0) {
          break;
        }

        restB /= x;
        ++divideCountB;
      }

      if (a == 0) {
        break;
      }

      a /= x;
      ++divideCountA;
    }

    return result;
  }
}