import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] a = new int[2 * n - 1][];
    for (int i = 0; i < a.length; ++i) {
      a[i] = new int[i + 1];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(n, a));

    sc.close();
  }

  static String solve(int n, int[][] a) {
    SortedMap<Integer, Pair> valueToPair = new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        valueToPair.put(a[i][j], new Pair(i + 1, j));
      }
    }

    int[] result = new int[2 * n];
    boolean[] used = new boolean[2 * n];
    for (Pair pair : valueToPair.values()) {
      if (!used[pair.person1()] && !used[pair.person2()]) {
        result[pair.person1()] = pair.person2() + 1;
        result[pair.person2()] = pair.person1() + 1;

        used[pair.person1()] = true;
        used[pair.person2()] = true;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

record Pair(int person1, int person2) {}
