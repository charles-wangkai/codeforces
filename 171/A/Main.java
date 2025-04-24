import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a1 = sc.nextInt();
    int a2 = sc.nextInt();

    System.out.println(solve(a1, a2));

    sc.close();
  }

  static int solve(int a1, int a2) {
    return a1 + Integer.parseInt(new StringBuilder(String.valueOf(a2)).reverse().toString());
  }
}