import java.util.Arrays;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    Arrays.sort(a);

    long result = 0;
    int leftIndex = 0;
    int rightIndex = a.length - 1;
    long sum = 0;
    while (leftIndex < rightIndex) {
      if (sum + a[leftIndex] < a[rightIndex]) {
        sum += a[leftIndex];
        ++leftIndex;
      } else if (sum + a[leftIndex] == a[rightIndex]) {
        result += a[rightIndex] + 1;
        ++leftIndex;
        --rightIndex;
        sum = 0;
      } else {
        a[leftIndex] -= a[rightIndex] - sum;
        result += a[rightIndex] + 1;
        --rightIndex;
        sum = 0;
      }
    }

    if (leftIndex == rightIndex) {
      int delta = (int) ((a[rightIndex] - sum) / 2);
      sum += delta;
      a[rightIndex] -= delta;
      if (sum != 0) {
        result += sum + 1;
      }
      result += a[rightIndex] - sum;
    }

    return result;
  }
}