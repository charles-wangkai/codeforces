import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();

      System.out.println(solve(x, y, z));
    }

    sc.close();
  }

  static String solve(int x, int y, int z) {
    char outcome;
    if (x >= y) {
      outcome = 'P';
    } else if (y >= z) {
      outcome = 'R';
    } else {
      outcome = 'S';
    }

    return String.valueOf(outcome).repeat(x + y + z);
  }
}