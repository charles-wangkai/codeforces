import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int result = -1;
    int lower = 0;
    int upper = a.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, b, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int[] b, int size) {
    int index = 0;
    for (int i = 0; i < a.length; ++i) {
      if (index != size && a[i] >= size - index - 1 && b[i] >= index) {
        ++index;
      }
    }

    return index == size;
  }
}