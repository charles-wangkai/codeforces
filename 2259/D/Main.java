import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

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
    SortedMap<Integer, List<Integer>> valueToIndices = new TreeMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    if (valueToIndices.getOrDefault(0, List.of()).size() == 1) {
      return "NO";
    }

    char[] distribution = new char[a.length];
    boolean balanced = true;
    for (List<Integer> indices : valueToIndices.values()) {
      if (balanced) {
        for (int i = 0; i < indices.size(); ++i) {
          distribution[indices.get(i)] = (char) (i % 3 + 'A');
        }
      } else {
        for (int index : indices) {
          distribution[index] = 'C';
        }
      }

      if (indices.size() < 3) {
        balanced = false;
      }
    }

    return "YES\n%s".formatted(String.valueOf(distribution));
  }
}