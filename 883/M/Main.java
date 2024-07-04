import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();

    System.out.println(solve(x1, y1, x2, y2));

    sc.close();
  }

  static int solve(int x1, int y1, int x2, int y2) {
    return (Math.max(2, Math.abs(x1 - x2) + 1) + Math.max(2, Math.abs(y1 - y2) + 1)) * 2;
  }
}