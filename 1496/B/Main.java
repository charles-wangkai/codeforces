import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    int max = Arrays.stream(a).max().getAsInt();
    Set<Integer> set = new HashSet<>();
    for (int ai : a) {
      set.add(ai);
    }
    for (int i = k; i >= 1; --i) {
      int mex = computeMex(set);
      if (mex == max + 1) {
        return set.size() + i;
      }

      int added = (mex + max + 1) / 2;
      if (set.contains(added)) {
        break;
      }

      set.add(added);
    }

    return set.size();
  }

  static int computeMex(Set<Integer> set) {
    for (int i = 0; ; ++i) {
      if (!set.contains(i)) {
        return i;
      }
    }
  }
}
