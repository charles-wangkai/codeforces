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
    int max = -1;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > max + 1) {
        return i + 1;
      }

      max = Math.max(max, a[i]);
    }

    return -1;
  }
}