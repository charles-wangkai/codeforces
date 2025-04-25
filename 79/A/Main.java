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
    boolean cielTurn = true;
    while (true) {
      if (cielTurn) {
        if (x >= 2 && y >= 2) {
          x -= 2;
          y -= 2;
        } else if (x >= 1 && y >= 12) {
          x -= 1;
          y -= 12;
        } else if (y >= 22) {
          y -= 22;
        } else {
          return "Hanako";
        }
      } else if (y >= 22) {
        y -= 22;
      } else if (x >= 1 && y >= 12) {
        x -= 1;
        y -= 12;
      } else if (x >= 2 && y >= 2) {
        x -= 2;
        y -= 2;
      } else {
        return "Ciel";
      }

      cielTurn ^= true;
    }
  }
}