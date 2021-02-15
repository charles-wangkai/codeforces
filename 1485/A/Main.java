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
    int result = Integer.MAX_VALUE;
    for (int i = (b == 1) ? 1 : 0; ; ++i) {
      int d = b + i;
      int operationNum = i;
      int rest = a;
      while (rest != 0) {
        rest /= d;
        ++operationNum;
      }

      if (operationNum > result) {
        break;
      }

      result = operationNum;
    }

    return result;
  }
}
