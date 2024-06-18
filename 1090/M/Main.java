import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    int result = 1;
    int count = 1;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] == a[i - 1]) {
        count = 1;
      } else {
        ++count;
        result = Math.max(result, count);
      }
    }

    return result;
  }
}