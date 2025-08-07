import java.util.ArrayList;
import java.util.List;
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

  static String solve(int[] a, int[] b) {
    Map<Integer, Integer> aValueToIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    List<String> operations = new ArrayList<>();

    int[] sameIndices = IntStream.range(0, a.length).filter(i -> a[i] == b[i]).toArray();
    if ((a.length % 2 == 0 && sameIndices.length > 0)
        || (a.length % 2 == 1 && sameIndices.length > 1)) {
      return "-1";
    }
    if (sameIndices.length != 0) {
      operate(a, b, aValueToIndex, operations, sameIndices[0], a.length / 2);
    }

    for (int i = 0; i < a.length - 1 - i; ++i) {
      int fromIndex = aValueToIndex.get(b[i]);
      if (b[fromIndex] != a[i]) {
        return "-1";
      }

      operate(a, b, aValueToIndex, operations, fromIndex, a.length - 1 - i);
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }

  static void operate(
      int[] a,
      int[] b,
      Map<Integer, Integer> aValueToIndex,
      List<String> operations,
      int index1,
      int index2) {
    if (index1 != index2) {
      swap(a, index1, index2);
      swap(b, index1, index2);

      aValueToIndex.put(a[index1], index1);
      aValueToIndex.put(a[index2], index2);

      operations.add("%d %d".formatted(index1 + 1, index2 + 1));
    }
  }

  static void swap(int[] values, int index1, int index2) {
    int temp = values[index1];
    values[index1] = values[index2];
    values[index2] = temp;
  }
}