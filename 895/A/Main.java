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
    int result = Integer.MAX_VALUE;
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      for (int endIndex = 0; endIndex < a.length; ++endIndex) {
        result = Math.min(result, computeDiff(a, beginIndex, endIndex));
      }
    }

    return result;
  }

  static int computeDiff(int[] a, int beginIndex, int endIndex) {
    int sum = 0;
    int index = beginIndex;
    while (true) {
      sum += a[index];
      if (index == endIndex) {
        break;
      }

      index = (index + 1) % a.length;
    }

    return Math.abs(sum - (360 - sum));
  }
}