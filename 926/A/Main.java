import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int l = sc.nextInt();
    int r = sc.nextInt();

    System.out.println(solve(l, r));

    sc.close();
  }

  static int solve(int l, int r) {
    int result = 0;
    for (long i = 1; i <= r; i *= 2) {
      for (long j = i; j <= r; j *= 3) {
        if (j >= l) {
          ++result;
        }
      }
    }

    return result;
  }
}