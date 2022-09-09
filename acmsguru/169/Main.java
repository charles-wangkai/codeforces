import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();

    System.out.println(solve(K));

    sc.close();
  }

  static int solve(int K) {
    if (K == 1) {
      return 8;
    }
    if (K % 3 != 1) {
      return 1;
    }
    if (K % 6 == 1) {
      return 4;
    }

    return 3;
  }
}