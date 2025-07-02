import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int n = a.length;

    int[] result = new int[n];
    Set<Integer> used = new HashSet<>();
    List<Integer> diffIndices = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (a[i] == b[i]) {
        result[i] = a[i];
        used.add(a[i]);
      } else {
        diffIndices.add(i);
      }
    }

    int[] missings = IntStream.rangeClosed(1, n).filter(i -> !used.contains(i)).toArray();
    if (diffIndices.size() == 1) {
      result[diffIndices.get(0)] = missings[0];
    } else {
      result[diffIndices.get(0)] = missings[0];
      result[diffIndices.get(1)] = missings[1];
      if (computeDiffNum(result, a) != 1 || computeDiffNum(result, b) != 1) {
        result[diffIndices.get(0)] = missings[1];
        result[diffIndices.get(1)] = missings[0];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int computeDiffNum(int[] x, int[] y) {
    return (int) IntStream.range(0, x.length).filter(i -> x[i] != y[i]).count();
  }
}