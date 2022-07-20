import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(n, a));
    }

    sc.close();
  }

  static int solve(int n, int[] a) {
    int[] counts = new int[n];
    for (int ai : a) {
      ++counts[ai];
    }

    int result = -1;
    int lower = 0;
    int upper = a.length * 2;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(counts, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] counts, int time) {
    long extra = 0;
    long needed = 0;
    for (int count : counts) {
      if (count <= time) {
        extra += (time - count) / 2;
      } else {
        needed += count - time;
      }
    }

    return extra >= needed;
  }
}