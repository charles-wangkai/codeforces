import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] r = new int[n];
    for (int i = 0; i < r.length; ++i) {
      r[i] = sc.nextInt();
    }
    int[] x = new int[k];
    int[] y = new int[k];
    for (int i = 0; i < k; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(r, x, y));

    sc.close();
  }

  static String solve(int[] r, int[] x, int[] y) {
    SortedMap<Integer, List<Integer>> skillToIndices = new TreeMap<>();
    for (int i = 0; i < r.length; ++i) {
      skillToIndices.putIfAbsent(r[i], new ArrayList<>());
      skillToIndices.get(r[i]).add(i);
    }

    int[] result = new int[r.length];
    int sum = 0;
    for (List<Integer> indices : skillToIndices.values()) {
      for (int index : indices) {
        result[index] = sum;
      }

      sum += indices.size();
    }

    for (int i = 0; i < x.length; ++i) {
      if (r[x[i] - 1] < r[y[i] - 1]) {
        --result[y[i] - 1];
      } else if (r[x[i] - 1] > r[y[i] - 1]) {
        --result[x[i] - 1];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}