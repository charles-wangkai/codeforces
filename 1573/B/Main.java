import java.util.ArrayList;
import java.util.List;
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

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (indices.isEmpty() || a[i] < a[indices.get(indices.size() - 1)]) {
        indices.add(i);
      }
    }

    return IntStream.range(0, b.length)
        .map(i -> i + computeOperationNum(a, indices, b[i]))
        .min()
        .getAsInt();
  }

  static int computeOperationNum(int[] a, List<Integer> indices, int target) {
    int result = -1;
    int lower = 0;
    int upper = indices.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[indices.get(middle)] < target) {
        result = indices.get(middle);
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}