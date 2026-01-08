import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();
    String s = sc.next();
    int n = sc.nextInt();
    int[] p = new int[n];
    char[] c = new char[n];
    for (int i = 0; i < n; ++i) {
      p[i] = sc.nextInt();
      c[i] = sc.next().charAt(0);
    }

    System.out.println(solve(k, s, p, c));

    sc.close();
  }

  static String solve(int k, String s, int[] p, char[] c) {
    String t = s.repeat(k);

    Map<Character, List<Integer>> letterToIndices = new HashMap<>();
    for (int i = 0; i < t.length(); ++i) {
      letterToIndices.putIfAbsent(t.charAt(i), new ArrayList<>());
      letterToIndices.get(t.charAt(i)).add(i);
    }

    Map<Character, FenwickTree> letterToFenwickTree = new HashMap<>();
    for (char letter : letterToIndices.keySet()) {
      letterToFenwickTree.put(letter, new FenwickTree(letterToIndices.get(letter).size()));
    }

    boolean[] deleted = new boolean[t.length()];
    for (int i = 0; i < p.length; ++i) {
      List<Integer> indices = letterToIndices.get(c[i]);
      FenwickTree fenwickTree = letterToFenwickTree.get(c[i]);

      int pos = find(fenwickTree, indices.size(), p[i] - 1);
      deleted[indices.get(pos)] = true;
      fenwickTree.add(pos + 1, 1);
    }

    return IntStream.range(0, deleted.length)
        .filter(i -> !deleted[i])
        .mapToObj(t::charAt)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static int find(FenwickTree fenwickTree, int size, int index) {
    int result = -1;
    int lower = 0;
    int upper = size - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (middle - fenwickTree.computePrefixSum(middle) <= index) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}

class FenwickTree {
  int[] a;

  FenwickTree(int size) {
    a = new int[Integer.highestOneBit(size) * 2 + 1];
  }

  void add(int pos, int delta) {
    while (pos < a.length) {
      a[pos] += delta;
      pos += pos & -pos;
    }
  }

  int computePrefixSum(int pos) {
    int result = 0;
    while (pos != 0) {
      result += a[pos];
      pos -= pos & -pos;
    }

    return result;
  }
}
