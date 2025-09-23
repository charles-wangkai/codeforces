import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();
    long M = sc.nextLong();
    long K = sc.nextLong();
    long L = sc.nextLong();

    System.out.println(solve(N, M, K, L));

    sc.close();
  }

  static long solve(long N, long M, long K, long L) {
    long result = (K + L + M - 1) / M;

    return (result * M <= N) ? result : -1;
  }
}