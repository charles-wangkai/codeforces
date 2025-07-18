import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    int[] lengths = new int[a.length];
    for (int i = lengths.length - 1; i >= 0; --i) {
      lengths[i] = (a[i] == 0) ? (1 + ((i == lengths.length - 1) ? 0 : lengths[i + 1])) : 0;
    }

    int result = 0;
    int index = 0;
    while (index < lengths.length) {
      if (lengths[index] >= k) {
        index += k + 1;
        ++result;
      } else {
        ++index;
      }
    }

    return result;
  }
}