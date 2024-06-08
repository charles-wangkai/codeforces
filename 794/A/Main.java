import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int n = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, x));

    sc.close();
  }

  static int solve(int a, int b, int c, int[] x) {
    return (int) Arrays.stream(x).filter(xi -> xi > b && xi < c).count();
  }
}