import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int p = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(p, y));

    sc.close();
  }

  static int solve(int p, int y) {
    for (int result = y; result > p; --result) {
      if (check(p, result)) {
        return result;
      }
    }

    return -1;
  }

  static boolean check(int p, int value) {
    for (int i = 2; i * i <= value; ++i) {
      if (value % i == 0 && i <= p) {
        return false;
      }
    }

    return true;
  }
}