// https://codeforces.com/blog/entry/13042

import java.util.Scanner;
import java.util.stream.IntStream;

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
    return search(a, 0, a.length - 1, 0);
  }

  static int search(int[] a, int beginIndex, int endIndex, int base) {
    int min = IntStream.rangeClosed(beginIndex, endIndex).map(i -> a[i]).min().getAsInt();

    int horizonStrokeNum = min - base;

    int nextBeginIndex = beginIndex;
    while (true) {
      while (nextBeginIndex != endIndex + 1 && a[nextBeginIndex] == min) {
        ++nextBeginIndex;
      }
      if (nextBeginIndex == endIndex + 1) {
        break;
      }

      int nextEndIndex = nextBeginIndex;
      while (nextEndIndex != endIndex && a[nextEndIndex + 1] != min) {
        ++nextEndIndex;
      }

      horizonStrokeNum += search(a, nextBeginIndex, nextEndIndex, min);

      nextBeginIndex = nextEndIndex + 1;
    }

    return (int) Math.min(horizonStrokeNum, endIndex - beginIndex + 1);
  }
}