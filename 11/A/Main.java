import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int d = sc.nextInt();
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(b, d));

    sc.close();
  }

  static int solve(int[] b, int d) {
    int result = 0;
    for (int i = 1; i < b.length; ++i) {
      int moveNum = (Math.max(0, b[i - 1] + 1 - b[i]) + d - 1) / d;
      result += moveNum;
      b[i] += d * moveNum;
    }

    return result;
  }
}
