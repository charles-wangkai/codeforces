import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int a) {
    return a * (a - 1) * 6 + 1;
  }
}