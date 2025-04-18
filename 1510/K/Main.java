import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[2 * n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static int solve(int[] p) {
    int result = Math.min(computeOperationNum(p, true), computeOperationNum(p, false));

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  static int computeOperationNum(int[] p, boolean isAdjSwap) {
    int result = 0;
    Set<Integer> firstSeen = new HashSet<>();
    while (!isSorted(p)) {
      if (firstSeen.contains(p[0])) {
        return Integer.MAX_VALUE;
      }
      firstSeen.add(p[0]);

      p = isAdjSwap ? swapAdj(p) : swapHalf(p);

      isAdjSwap ^= true;
      ++result;
    }

    return result;
  }

  static int[] swapHalf(int[] p) {
    int[] result = p.clone();
    for (int i = 0; i < p.length / 2; ++i) {
      swap(result, i, i + p.length / 2);
    }

    return result;
  }

  static int[] swapAdj(int[] p) {
    int[] result = p.clone();
    for (int i = 0; i < p.length / 2; ++i) {
      swap(result, i * 2, i * 2 + 1);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static boolean isSorted(int[] p) {
    return IntStream.range(0, p.length - 1).allMatch(i -> p[i] < p[i + 1]);
  }
}