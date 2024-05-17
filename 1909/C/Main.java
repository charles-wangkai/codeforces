import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      for (int i = 0; i < l.length; ++i) {
        l[i] = sc.nextInt();
      }
      int[] r = new int[n];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, c));
    }

    sc.close();
  }

  static long solve(int[] l, int[] r, int[] c) {
    Arrays.sort(l);
    Arrays.sort(r);

    int leftIndex = 0;
    int rightIndex = 0;
    Deque<Integer> leftStack = new ArrayDeque<>();
    List<Integer> lengths = new ArrayList<>();
    while (leftIndex != l.length || rightIndex != r.length) {
      if (rightIndex == r.length || (leftIndex != l.length && l[leftIndex] < r[rightIndex])) {
        leftStack.push(l[leftIndex]);
        ++leftIndex;
      } else {
        lengths.add(r[rightIndex] - leftStack.pop());
        ++rightIndex;
      }
    }

    Collections.sort(lengths, Comparator.reverseOrder());
    Arrays.sort(c);

    return IntStream.range(0, lengths.size()).mapToLong(i -> (long) lengths.get(i) * c[i]).sum();
  }
}