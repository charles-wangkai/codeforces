import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(String.format("%.9f", solve(N, M)));

    sc.close();
  }

  static double solve(int N, int M) {
    return (1 - Math.pow(1 - 1.0 / N, M)) * N;
  }
}