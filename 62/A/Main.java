import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int girlLeft = sc.nextInt();
    int girlRight = sc.nextInt();
    int boyLeft = sc.nextInt();
    int boyRight = sc.nextInt();

    System.out.println(solve(girlLeft, girlRight, boyLeft, boyRight) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int girlLeft, int girlRight, int boyLeft, int boyRight) {
    return check(girlLeft, boyRight) || check(girlRight, boyLeft);
  }

  static boolean check(int girl, int boy) {
    return boy >= girl - 1 && boy <= 2 * (girl + 1);
  }
}