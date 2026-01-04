// https://codeforces.com/blog/entry/12513

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
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
    SegTree segTree = new SegTree(a);
    for (String operation : operations) {
      int[] fields = Arrays.stream(operation.split(" ")).mapToInt(Integer::parseInt).toArray();
      int type = fields[0];
      if (type == 1) {
        int l = fields[1];
        int r = fields[2];

        result.add(segTree.querySum(l - 1, r - 1));
      } else if (type == 2) {
        int l = fields[1];
        int r = fields[2];
        int x = fields[3];

        segTree.updateMod(l - 1, r - 1, x);
      } else {
        int k = fields[1];
        int x = fields[2];

        segTree.updateValue(k - 1, x);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class SegTree {
  Node root;

  SegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Node(beginIndex, endIndex, values[beginIndex], values[beginIndex], null, null);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Node left = buildNode(values, beginIndex, middleIndex);
    Node right = buildNode(values, middleIndex + 1, endIndex);

    return new Node(
        beginIndex,
        endIndex,
        Math.max(left.maxValue, right.maxValue),
        left.sum + right.sum,
        left,
        right);
  }

  void updateValue(int index, int value) {
    updateValue(index, value, root);
  }

  private void updateValue(int index, int value, Node node) {
    if (node.beginIndex <= index && node.endIndex >= index) {
      if (node.beginIndex == node.endIndex) {
        node.maxValue = value;
        node.sum = node.maxValue;
      } else {
        updateValue(index, value, node.left);
        updateValue(index, value, node.right);

        node.maxValue = Math.max(node.left.maxValue, node.right.maxValue);
        node.sum = node.left.sum + node.right.sum;
      }
    }
  }

  void updateMod(int beginIndex, int endIndex, int x) {
    updateMod(beginIndex, endIndex, x, root);
  }

  private void updateMod(int beginIndex, int endIndex, int x, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)
        && queryMaxValue(beginIndex, endIndex, node) >= x) {
      if (node.beginIndex == node.endIndex) {
        node.maxValue %= x;
        node.sum = node.maxValue;
      } else {
        updateMod(beginIndex, endIndex, x, node.left);
        updateMod(beginIndex, endIndex, x, node.right);

        node.maxValue = Math.max(node.left.maxValue, node.right.maxValue);
        node.sum = node.left.sum + node.right.sum;
      }
    }
  }

  public int queryMaxValue(int beginIndex, int endIndex) {
    return queryMaxValue(beginIndex, endIndex, root);
  }

  private int queryMaxValue(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return Integer.MIN_VALUE;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.maxValue;
    }

    return Math.max(
        queryMaxValue(beginIndex, endIndex, node.left),
        queryMaxValue(beginIndex, endIndex, node.right));
  }

  public long querySum(int beginIndex, int endIndex) {
    return querySum(beginIndex, endIndex, root);
  }

  private long querySum(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.sum;
    }

    return querySum(beginIndex, endIndex, node.left) + querySum(beginIndex, endIndex, node.right);
  }

  static class Node {
    int beginIndex;
    int endIndex;
    int maxValue;
    long sum;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex, int maxValue, long sum, Node left, Node right) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
      this.maxValue = maxValue;
      this.sum = sum;
      this.left = left;
      this.right = right;
    }
  }
}
