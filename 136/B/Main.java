import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(solve(a, c));

    sc.close();
  }

  static int solve(int a, int c) {
    int result = 0;
    int placeValue = 1;
    while (a != 0 || c != 0) {
      result += placeValue * Math.floorMod(c % 3 - a % 3, 3);
      placeValue *= 3;
      a /= 3;
      c /= 3;
    }

    return result;
  }
}