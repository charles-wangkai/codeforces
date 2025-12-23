import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    int[] result = new int[a.length];
    List<Integer> indices = new ArrayList<>();
    for (int i = result.length - 1; i >= 0; --i) {
      int pos = findPos(a, indices, a[i]);
      if (pos == indices.size()) {
        result[i] = -1;
        indices.add(i);
      } else {
        result[i] = indices.get(pos) - i - 1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int findPos(int[] a, List<Integer> indices, int value) {
    int result = indices.size();
    int lower = 0;
    int upper = indices.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[indices.get(middle)] < value) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}