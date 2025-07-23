import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int w = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, w));

    sc.close();
  }

  static int solve(int[] a, int w) {
    int minSum = 0;
    int maxSum = 0;
    int sum = 0;
    for (int ai : a) {
      sum += ai;
      minSum = Math.min(minSum, sum);
      maxSum = Math.max(maxSum, sum);
    }

    return Math.max(0, (w - maxSum) - -minSum + 1);
  }
}