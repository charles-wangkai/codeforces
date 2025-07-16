import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();

    System.out.println(solve(x));

    sc.close();
  }

  static int solve(int x) {
    int result = 0;
    for (int i = 1; i * i <= x; ++i) {
      if (x % i == 0) {
        if (hasCommonDigit(x, i)) {
          ++result;
        }
        if (x / i != i && hasCommonDigit(x, x / i)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean hasCommonDigit(int value1, int value2) {
    return String.valueOf(value1).chars().distinct().count()
            + String.valueOf(value2).chars().distinct().count()
        != (String.valueOf(value1) + String.valueOf(value2)).chars().distinct().count();
  }
}