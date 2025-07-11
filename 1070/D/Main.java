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

    System.out.println(solve(a, k));

    sc.close();
  }

  static long solve(int[] a, int k) {
    long result = 0;
    int excess = 0;
    for (int ai : a) {
      int rest = Math.max(0, ai - excess);
      result += rest / k;
      if (rest % k != 0) {
        ++result;
        excess = k - rest % k;
      } else {
        excess = 0;
      }
    }

    return result;
  }
}