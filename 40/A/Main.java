import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(x, y));

    sc.close();
  }

  static String solve(int x, int y) {
    int distanceSquare = x * x + y * y;
    int root = (int) Math.round(Math.sqrt(distanceSquare));
    if (root * root == distanceSquare) {
      return "black";
    }

    if (root * root > distanceSquare) {
      --root;
    }

    return ((root + ((x * y > 0) ? 0 : 1)) % 2 == 0) ? "black" : "white";
  }
}