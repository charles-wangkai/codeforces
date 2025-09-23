import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int result = 0;
    int rest25 = n;
    int rest21 = n;
    int rest18 = n;
    while (rest25 + rest21 + rest18 != 0) {
      if (rest25 >= 2) {
        rest25 -= 2;
      } else if (rest25 == 1) {
        --rest25;

        if (rest21 != 0) {
          --rest21;
        } else {
          rest18 = Math.max(0, rest18 - 1);
        }
      } else if (rest21 >= 2) {
        rest21 -= 2;

        rest18 = Math.max(0, rest18 - 1);
      } else if (rest21 == 1) {
        --rest21;

        rest18 = Math.max(0, rest18 - 2);
      } else {
        rest18 = Math.max(0, rest18 - 3);
      }

      ++result;
    }

    return result;
  }
}