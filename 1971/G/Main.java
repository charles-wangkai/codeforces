import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    Map<Integer, List<Integer>> groupToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      int group = a[i] & (~3);
      groupToIndices.putIfAbsent(group, new ArrayList<>());
      groupToIndices.get(group).add(i);
    }

    int[] result = new int[a.length];
    for (List<Integer> indices : groupToIndices.values()) {
      int[] sortedValues = indices.stream().mapToInt(index -> a[index]).sorted().toArray();
      for (int i = 0; i < indices.size(); ++i) {
        result[indices.get(i)] = sortedValues[i];
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}