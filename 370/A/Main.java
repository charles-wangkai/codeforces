import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    int r2 = sc.nextInt();
    int c2 = sc.nextInt();

    System.out.println(solve(r1, c1, r2, c2));

    sc.close();
  }

  static String solve(int r1, int c1, int r2, int c2) {
    return String.format(
        "%d %d %d",
        (r1 == r2 || c1 == c2) ? 1 : 2,
        ((r1 + c1) % 2 == (r2 + c2) % 2) ? ((r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2) ? 1 : 2) : 0,
        Math.max(Math.abs(r1 - r2), Math.abs(c1 - c2)));
  }
}