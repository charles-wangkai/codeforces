import java.util.OptionalInt;
import java.util.Scanner;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    OptionalInt optionalIndex = IntStream.range(0, b.length).filter(i -> b[i] != 0).findAny();
    if (optionalIndex.isEmpty()) {
      return true;
    }

    int operationNum = a[optionalIndex.getAsInt()] - b[optionalIndex.getAsInt()];
    if (operationNum < 0) {
      return false;
    }

    return IntStream.range(0, a.length).allMatch(i -> b[i] == Math.max(0, a[i] - operationNum));
  }
}