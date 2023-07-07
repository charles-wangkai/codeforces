import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

      System.out.println(solve(a) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int mex = computeMex(a);
    int[] nextMexIndices = IntStream.range(0, a.length).filter(i -> a[i] == mex + 1).toArray();
    if (nextMexIndices.length == 0) {
      return mex != a.length;
    }

    for (int i = nextMexIndices[0]; i <= nextMexIndices[nextMexIndices.length - 1]; ++i) {
      a[i] = mex;
    }

    return computeMex(a) == mex + 1;
  }

  static int computeMex(int[] a) {
    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
    for (int i = 0; ; ++i) {
      if (!set.contains(i)) {
        return i;
      }
    }
  }
}
