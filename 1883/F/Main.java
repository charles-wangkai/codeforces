import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Deque<Integer> rightIndices = new ArrayDeque<>();
    Set<Integer> rightSeen = new HashSet<>();
    for (int i = a.length - 1; i >= 0; --i) {
      if (!rightSeen.contains(a[i])) {
        rightIndices.push(i);
        rightSeen.add(a[i]);
      }
    }

    long result = 0;
    Set<Integer> leftSeen = new HashSet<>();
    for (int i = 0; i < a.length; ++i) {
      if (!leftSeen.contains(a[i])) {
        result += rightIndices.size();
        leftSeen.add(a[i]);
      }

      if (!rightIndices.isEmpty() && rightIndices.peek() == i) {
        rightIndices.pop();
      }
    }

    return result;
  }
}