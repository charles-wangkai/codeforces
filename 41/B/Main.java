import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int b = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int b) {
    int result = b;
    int max = 0;
    for (int i = a.length - 1; i >= 0; --i) {
      max = Math.max(max, a[i]);
      result = Math.max(result, b % a[i] + b / a[i] * max);
    }

    return result;
  }
}