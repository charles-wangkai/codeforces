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
    long result = 0;
    for (int i = 0; i < a.length; ++i) {
      result += 1 + (a[i] - 1) * (i + 1L);
    }

    return result;
  }
}