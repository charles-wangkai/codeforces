import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
      String s = sc.next();
      int q = sc.nextInt();
      String[] queries = new String[q];
      sc.nextLine();
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(a, s, queries));
    }

    sc.close();
  }

  static String solve(int[] a, String s, String[] queries) {
    List<Integer> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(s, a);
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int l = fields[1];
        int r = fields[2];

        lazySegTree.update(l - 1, r - 1);
      } else {
        int g = fields[1];

        result.add(lazySegTree.root.getComputedXor(g));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}

class LazySegTree {
  Node root;

  LazySegTree(String s, int[] values) {
    root = buildNode(s, values, 0, values.length - 1);
  }

  private Node buildNode(String s, int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex, false);

    if (beginIndex == endIndex) {
      node.xors[s.charAt(beginIndex) - '0'] = values[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(s, values, beginIndex, middleIndex);
      node.right = buildNode(s, values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int beginIndex, int endIndex) {
    update(beginIndex, endIndex, root);
  }

  private void update(int beginIndex, int endIndex, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply();
      } else {
        node.pushDown();

        update(beginIndex, endIndex, node.left);
        update(beginIndex, endIndex, node.right);

        node.pull();
      }
    }
  }

  static class Node {
    int beginIndex;
    int endIndex;
    boolean flipped;
    int[] xors = new int[2];
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, boolean flipped) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.flipped = flipped;
    }

    int getComputedXor(int b) {
      return flipped ? xors[1 - b] : xors[b];
    }

    void pushDown() {
      if (flipped) {
        left.apply();
        right.apply();

        flipped = false;
      }
    }

    void apply() {
      flipped ^= true;
    }

    void pull() {
      for (int i = 0; i < xors.length; ++i) {
        xors[i] = left.getComputedXor(i) ^ right.getComputedXor(i);
      }
    }
  }
}
