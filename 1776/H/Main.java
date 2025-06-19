import java.util.Map;
import java.util.Scanner;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    Map<Integer, Integer> valueToAIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    int result = b.length;
    int lastIndex = Integer.MAX_VALUE;
    for (int i = b.length - 1; i >= 0; --i) {
      int aIndex = valueToAIndex.get(b[i]);
      if (aIndex > lastIndex) {
        break;
      }

      --result;
      lastIndex = aIndex;
    }

    return result;
  }
}