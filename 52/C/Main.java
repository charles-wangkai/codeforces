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
    int m = sc.nextInt();
    sc.nextLine();
    String[] operations = new String[m];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = sc.nextLine();
    }

    System.out.println(solve(a, operations));

    sc.close();
  }

  static String solve(int[] a, String[] operations) {
    List<Long> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(a);
    for (String operation : operations) {
      int[] fields = Arrays.stream(operation.split(" ")).mapToInt(Integer::parseInt).toArray();
      int left = fields[0];
      int right = fields[1];

      if (fields.length == 3) {
        int v = fields[2];

        if (left <= right) {
          lazySegTree.update(left, right, v);
        } else {
          lazySegTree.update(left, a.length - 1, v);
          lazySegTree.update(0, right, v);
        }
      } else if (left <= right) {
        result.add(lazySegTree.query(left, right));
      } else {
        result.add(Math.min(lazySegTree.query(left, a.length - 1), lazySegTree.query(0, right)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class LazySegTree {
  Node root;

  LazySegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex, 0);

    if (beginIndex == endIndex) {
      node.minValue = values[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void update(int beginIndex, int endIndex, int delta) {
    update(beginIndex, endIndex, delta, root);
  }

  private void update(int beginIndex, int endIndex, int delta, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply(delta);
      } else {
        node.pushDown();

        update(beginIndex, endIndex, delta, node.left);
        update(beginIndex, endIndex, delta, node.right);

        node.pull();
      }
    }
  }

  long query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private long query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return Long.MAX_VALUE;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.getComputedMinValue();
    }

    node.pushDown();

    node.pull();

    return Math.min(
        query(beginIndex, endIndex, node.left), query(beginIndex, endIndex, node.right));
  }

  static class Node {
    int beginIndex;
    int endIndex;
    long delta;
    long minValue;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, long delta) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.delta = delta;
    }

    long getComputedMinValue() {
      return minValue + delta;
    }

    void pushDown() {
      if (delta != 0) {
        left.apply(delta);
        right.apply(delta);

        delta = 0;
      }
    }

    void apply(long d) {
      delta += d;
    }

    void pull() {
      minValue = Math.min(left.getComputedMinValue(), right.getComputedMinValue());
    }
  }
}
