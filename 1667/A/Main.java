import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    long result = Long.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      long moveNum = 0;

      long prev = 0;
      for (int j = i + 1; j < a.length; ++j) {
        prev = (prev + a[j]) / a[j] * a[j];
        moveNum += prev / a[j];
      }

      prev = 0;
      for (int j = i - 1; j >= 0; --j) {
        prev = (prev + a[j]) / a[j] * a[j];
        moveNum += prev / a[j];
      }

      result = Math.min(result, moveNum);
    }

    return result;
  }
}