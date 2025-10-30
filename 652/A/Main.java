import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h1 = sc.nextInt();
    int h2 = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(h1, h2, a, b));

    sc.close();
  }

  static int solve(int h1, int h2, int a, int b) {
    int result = 0;
    int hour = 14;
    int prev = Integer.MIN_VALUE;
    while (true) {
      if (hour >= 10 && hour < 22) {
        h1 += a;
      } else {
        h1 -= b;
      }

      if (h1 >= h2) {
        return result;
      }

      hour = (hour + 1) % 24;
      if (hour == 22) {
        if (h1 <= prev) {
          return -1;
        }

        prev = h1;
      } else if (hour == 0) {
        ++result;
      }
    }
  }
}