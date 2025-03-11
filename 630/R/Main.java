import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long n = sc.nextLong();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(long n) {
    return (n % 2 == 1) ? 1 : 2;
  }
}