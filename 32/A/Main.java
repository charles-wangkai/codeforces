import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int d = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, d));

    sc.close();
  }

  static int solve(int[] a, int d) {
    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        if (Math.abs(a[i] - a[j]) <= d) {
          result += 2;
        }
      }
    }

    return result;
  }
}
