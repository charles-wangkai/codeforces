import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int w = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(w, b));
    }

    sc.close();
  }

  static int solve(int w, int b) {
    int result = 0;
    int lower = 1;
    int upper = (int) Math.ceil(Math.sqrt((w + b) * 2L));
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(w, b, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int w, int b, int row) {
    int min = Math.min(w, b);
    int max = Math.max(w, b);
    for (int i = row; i >= 1; --i) {
      if (i > max) {
        return false;
      }

      if (i <= min) {
        min -= i;
      } else {
        max -= i;

        if (min > max) {
          int temp = min;
          min = max;
          max = temp;
        }
      }
    }

    return true;
  }
}