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
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      sc.nextLine();
      String[] queries = new String[q];
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(a, queries));
    }

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    List<Integer> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(a.length);
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        lazySegTree.update(fields[1] - 1, fields[2] - 1);
      } else {
        int index = fields[1] - 1;
        result.add(computeValue(a[index], lazySegTree.query(index, index)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int computeValue(int x, int count) {
    return (count == 0 || x <= 9)
        ? x
        : computeValue(String.valueOf(x).chars().map(c -> c - '0').sum(), count - 1);
  }
}

class LazySegTree {
  Node root;

  LazySegTree(int n) {
    root = buildNode(0, n - 1);
  }

  private Node buildNode(int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex, 0);

    if (beginIndex != endIndex) {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(beginIndex, middleIndex);
      node.right = buildNode(middleIndex + 1, endIndex);
    }

    return node;
  }

  void update(int beginIndex, int endIndex) {
    update(beginIndex, endIndex, root);
  }

  private void update(int beginIndex, int endIndex, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply(1);
      } else {
        node.pushDown();

        update(beginIndex, endIndex, node.left);
        update(beginIndex, endIndex, node.right);
      }
    }
  }

  int query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private int query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.count;
    }

    node.pushDown();

    return query(beginIndex, endIndex, node.left) + query(beginIndex, endIndex, node.right);
  }

  static class Node {
    int beginIndex;
    int endIndex;
    int count;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, int count) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.count = count;
    }

    void pushDown() {
      if (count != 0) {
        left.apply(count);
        right.apply(count);

        count = 0;
      }
    }

    void apply(int d) {
      count += d;
    }
  }
}
