import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int[] c = new int[m];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(c, x, y));

    sc.close();
  }

  static int solve(int[] c, int x, int y) {
    int group1 = Arrays.stream(c).sum();
    int group2 = 0;
    for (int i = c.length - 1; i >= 0; --i) {
      group1 -= c[i];
      group2 += c[i];
      if (group1 >= x && group1 <= y && group2 >= x && group2 <= y) {
        return i + 1;
      }
    }

    return 0;
  }
}