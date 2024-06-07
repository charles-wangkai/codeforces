import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static long solve(int N, int M) {
    return (M == 1) ? (N - 1) : (N * (M - 1L));
  }
}