import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int index = a.length - 1;
    while (index != -1 && a[index] == 0) {
      --index;
    }
    if (index == -1) {
      return true;
    }

    long sum = 0;
    while (true) {
      sum += a[index];
      if (sum > 0) {
        return false;
      }
      if (sum == 0) {
        return index == 0;
      }

      --index;
      if (index == -1) {
        return false;
      }
    }
  }
}