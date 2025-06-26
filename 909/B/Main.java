import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int left = (N - 1) / 2;
    int right = N - 1 - left;

    return (left + 1) * (right + 1);
  }
}