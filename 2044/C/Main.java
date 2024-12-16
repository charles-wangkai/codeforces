import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int m = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      System.out.println(solve(m, a, b, c));
    }

    sc.close();
  }

  static int solve(int m, int a, int b, int c) {
    int monkey1 = Math.min(m, a);
    int monkey2 = Math.min(m, b);
    int monkey3 = Math.min(2 * m - monkey1 - monkey2, c);

    return monkey1 + monkey2 + monkey3;
  }
}