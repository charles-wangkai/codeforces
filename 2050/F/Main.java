import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r) {
    if (a.length == 1) {
      return IntStream.range(0, l.length)
          .map(i -> 0)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining(" "));
    }

    SegTree segTree =
        new SegTree(IntStream.range(0, a.length - 1).map(i -> Math.abs(a[i] - a[i + 1])).toArray());

    return IntStream.range(0, l.length)
        .map(i -> segTree.query(l[i] - 1, r[i] - 2))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}

class SegTree {
  Node root;

  SegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);

    if (beginIndex == endIndex) {
      node.g = values[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  int query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private int query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.g;
    }

    return Node.gcd(
        query(beginIndex, endIndex, node.left), query(beginIndex, endIndex, node.right));
  }

  static class Node {
    int beginIndex;
    int endIndex;
    int g;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
    }

    void pull() {
      g = gcd(left.g, right.g);
    }

    private static int gcd(int x, int y) {
      return (y == 0) ? x : gcd(y, x % y);
    }
  }
}
