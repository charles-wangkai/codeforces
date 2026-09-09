import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      long k = sc.nextLong();

      System.out.println(solve(x, y, k));
    }

    sc.close();
  }

  static long solve(int x, int y, long k) {
    long result = 0;
    for (int i = 0; i < k; ++i) {
      int projectNum = y + i;
      int employeeNum = x + i;
      if (projectNum / employeeNum == 1) {
        result += (k - i) * (y - x);

        break;
      }

      result += projectNum % employeeNum;
    }

    return result;
  }
}