import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int p1 = sc.nextInt();
      int p2 = sc.nextInt();
      int p3 = sc.nextInt();

      System.out.println(solve(p1, p2, p3));
    }

    sc.close();
  }

  static int solve(int p1, int p2, int p3) {
    if ((p1 + p2 + p3) % 2 == 1) {
      return -1;
    }

    return (p1 + p2 >= p3) ? ((p1 + p2 + p3) / 2) : (p1 + p2);
  }
}