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

  static String solve(int[] a) {
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a.length; ++j) {
        for (int k = 0; k < a.length; ++k) {
          if (j != i && k != i && k != j && a[i] == a[j] + a[k]) {
            return String.format("%d %d %d", i + 1, j + 1, k + 1);
          }
        }
      }
    }

    return "-1";
  }
}