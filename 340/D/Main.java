import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    return computeLongestIncreasingSubsequenceLength(a);
  }

  static int computeLongestIncreasingSubsequenceLength(int[] a) {
    List<Integer> tails = new ArrayList<>();
    for (int x : a) {
      int index = Collections.binarySearch(tails, x);
      if (index < 0) {
        index = -1 - index;
      }

      if (index == tails.size()) {
        tails.add(x);
      } else {
        tails.set(index, x);
      }
    }

    return tails.size();
  }
}