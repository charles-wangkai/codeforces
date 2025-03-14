import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int t = sc.nextInt();

    System.out.println(String.format("%.9f", solve(n, t)));

    sc.close();
  }

  static double solve(int n, int t) {
    return n * Math.pow(1.000000011, t);
  }
}