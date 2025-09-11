import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

  static long solve(int[] a) {
    Set<Integer> rightSeen = new HashSet<>();
    boolean[] rightFirsts = new boolean[a.length];
    for (int i = rightFirsts.length - 1; i >= 0; --i) {
      rightFirsts[i] = !rightSeen.contains(a[i]);
      rightSeen.add(a[i]);
    }

    long result = 0;
    Set<Integer> leftSeen = new HashSet<>();
    for (int i = 0; i < a.length; ++i) {
      if (rightFirsts[i]) {
        result += leftSeen.size();
      }

      leftSeen.add(a[i]);
    }

    return result;
  }
}