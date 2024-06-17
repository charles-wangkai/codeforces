import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    for (int i = 1; ; ++i) {
      if (i * i >= N) {
        return i * 4;
      }
      if (i * (i + 1) >= N) {
        return i * 4 + 2;
      }
    }
  }
}