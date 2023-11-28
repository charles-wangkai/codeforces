import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static String solve(int a, int b, int c) {
    return String.format(
        "%d %d %d",
        canRemainOnly(a, b, c) ? 1 : 0,
        canRemainOnly(b, c, a) ? 1 : 0,
        canRemainOnly(c, a, b) ? 1 : 0);
  }

  static boolean canRemainOnly(int count1, int count2, int count3) {
    if (count2 > count3) {
      return canRemainOnly(count1, count3, count2);
    }

    return (count3 - count2) % 2 == 0 && count1 + count2 >= 1;
  }
}