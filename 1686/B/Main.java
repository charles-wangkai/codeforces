import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = 0;
    int index = 0;
    while (index != p.length) {
      if (index + 1 != p.length && p[index] > p[index + 1]) {
        ++result;
        index += 2;
      } else {
        ++index;
      }
    }

    return result;
  }
}