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
    int[] counts = new int[3];
    for (int ai : a) {
      ++counts[ai % 3];
    }

    return counts[0] / 2 + Math.min(counts[1], counts[2]);
  }
}