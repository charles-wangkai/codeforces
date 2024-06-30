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

  static int solve(int[] a) {
    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      int xor = 0;
      for (int j = i; j < a.length; ++j) {
        xor ^= a[j];
        result = Math.max(result, xor);
      }
    }

    return result;
  }
}