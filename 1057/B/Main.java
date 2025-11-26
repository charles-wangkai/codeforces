import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] r = new int[n];
    for (int i = 0; i < r.length; ++i) {
      r[i] = sc.nextInt();
    }

    System.out.println(solve(r));

    sc.close();
  }

  static int solve(int[] r) {
    int result = 0;
    for (int i = 0; i < r.length; ++i) {
      int sum = 0;
      for (int j = i; j < r.length; ++j) {
        sum += r[j];
        if (sum > 100 * (j - i + 1)) {
          result = Math.max(result, j - i + 1);
        }
      }
    }

    return result;
  }
}