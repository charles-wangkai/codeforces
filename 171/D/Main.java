import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();

    System.out.println(solve(x));

    sc.close();
  }

  static int solve(int x) {
    if (x == 1) {
      return 2;
    }
    if (x == 2) {
      return 3;
    }
    if (x == 3) {
      return 1;
    }
    if (x == 4) {
      return 2;
    }

    return 1;
  }
}